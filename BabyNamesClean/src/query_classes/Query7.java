package query_classes;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import managers.Data;

public class Query7 extends QueryHelper {
	// Give the average rank of a name/gender pair in a range of years
	Scanner scanner = new Scanner(System.in);

	public void runQ7(Map<String, ArrayList<Data>> babyNamesData) {
		System.out.println("Select a name");
		String name = scanner.nextLine();
		name = capitalizeName(name);

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

		Map<String, String> yearRanks = new TreeMap<String, String>();

		for (int year = Integer.parseInt(minYear); year <= Integer.parseInt(maxYear); year++) {
			yearRanks.put(String.valueOf(year),
					String.valueOf(getRank(String.valueOf(year), name, gender, babyNamesData)));
		}

		int avgRank = getAverageRank(yearRanks);
		printQ7Data(name, gender, avgRank, minYear, maxYear);
	}

	private void printQ7Data(String name, String gender, int avgRank, String minYear, String maxYear) {
		System.out.println("The average rank of name " + name + ", and gender " + gender + ", is " + avgRank + " between "
				+ minYear + " and " + maxYear);
	}

	private int getAverageRank(Map<String, String> yearRanks) {
		int initial = 0;

		for (String key : yearRanks.keySet()) {
			initial += Integer.parseInt(yearRanks.get(key));
		}

		return initial / yearRanks.size();
	}
}
