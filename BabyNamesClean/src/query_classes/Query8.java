package query_classes;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import managers.Data;

public class Query8 extends QueryHelper {
	// Give the most popular letter for a specific gender, along with all the names
	// that start with that letter.
	Scanner scanner = new Scanner(System.in);

	public void runQ8(Map<String, ArrayList<Data>> babyNamesData) {
		System.out.println("Select a gender");
		String gender = scanner.nextLine().toUpperCase();
		if (!isGenderValid(gender)) {
			System.out.println("Invalid Gender, try again.");
			return;
		}

		System.out.println("Select a start year");
		String minYear = scanner.nextLine();

		System.out.println("Select an end year");
		String maxYear = scanner.nextLine();

		String mostPopLetter = getMostPopularLetter(gender, minYear, maxYear, babyNamesData);
		
		System.out.println(mostPopLetter + " is the most popular letter");

		// getPopularNamesBasedOnLetter();
		// getNamesThatStartWithLetter();

	}

	private String getMostPopularLetter(String gender, String minYear, String maxYear, Map<String, ArrayList<Data>> babyNamesData) {
		Map<String, ArrayList<String>> sortedByLetter = getNamesByLetter(babyNamesData, minYear, maxYear, gender);

		String mostPopLetter = "";
		int size = 0;
		
		for (String letter : sortedByLetter.keySet()) {
			ArrayList<String> names = sortedByLetter.get(letter);
			
			if(names.size() > size) {
				size = names.size();
				mostPopLetter = letter;
			}
			
		}
		
		return mostPopLetter;
	}

	private Map<String, ArrayList<String>> getNamesByLetter(Map<String, ArrayList<Data>> babyNamesData, String minYear, String maxYear, String gender) {
		Map<String, ArrayList<String>> sortedByLetter = new TreeMap<String, ArrayList<String>>();

		ArrayList<String> names = putNamesInList(babyNamesData, minYear, maxYear, gender);
		ArrayList<String> setOfLetters = new ArrayList<String>();
		
		for (String i : names) {
			String firstLetter = i.substring(0);
			if (!setOfLetters.contains(firstLetter)) {
				ArrayList<String> tempNames = new ArrayList<String>();
				for (String j : names) {
					if(j.substring(0).equals(firstLetter)) {
						tempNames.add(j);
					}
				}
				setOfLetters.add(firstLetter);
				sortedByLetter.put(firstLetter, tempNames);
			}
		}
		System.out.println(sortedByLetter.toString());
		return sortedByLetter;
	}

	private ArrayList<String> putNamesInList(Map<String, ArrayList<Data>> babyNamesData, String minYear, String maxYear,
			String gender) {

		ArrayList<String> names = new ArrayList<String>();

		for (int i = Integer.parseInt(minYear); i <= Integer.parseInt(maxYear); i++) {
			for (Data data : babyNamesData.get(String.valueOf(i))) {
				if (data.getGender().equals(gender)) {
					String name = data.getName();

					if (!names.contains(name)) {
						names.add(name);
					}
				}
			}
		}

		return names;
	}

	private void getPopularNamesBasedOnLetter() {

	}

	private void getNamesThatStartWithLetter() {

	}

	private void printQ8Data() {

	}

}
