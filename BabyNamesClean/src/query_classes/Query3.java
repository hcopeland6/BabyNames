package query_classes;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import managers.Data;

public class Query3 extends QueryHelper {

	Scanner scanner = new Scanner(System.in);

	public void runQ3(Map<String, ArrayList<Data>> babyNamesData) {
		System.out.println("Select a name");
		String name = scanner.nextLine();
		System.out.println("Select a gender");
		String gender = scanner.nextLine().toUpperCase();

		String[] unparsedYearAndFreq = getYearAndFreqForMostPopularNameGender(babyNamesData, name, gender);
		String year = unparsedYearAndFreq[0];
		String freq = unparsedYearAndFreq[1];

		printQ3Data(name, gender, year, freq, babyNamesData);
	}

	private void printQ3Data(String name, String gender, String year, String freq,
			Map<String, ArrayList<Data>> babyNamesData) {
		System.out.println("The name " + name + ", gender " + gender + ", in the year " + year
				+ ", occurred with frequency " + freq + ", and rank " + getRank(year, name, gender, babyNamesData)
				+ " in the " + gender + " group.");
	}
}
