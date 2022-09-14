package query_classes;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import managers.Data;

public class Query6 extends QueryHelper {
	// Compare the rank of one name/gender pair in a specific year to that of their
	// rank in next closest year
	Scanner scanner = new Scanner(System.in);

	public void runQ6(Map<String, ArrayList<Data>> babyNamesData) {
		System.out.println("Select a name");
		String name = scanner.nextLine();
		name = capitalizeName(name);

		System.out.println("Select a gender");
		String gender = scanner.nextLine().toUpperCase();
		if (!isGenderValid(gender)) {
			System.out.println("Invalid Gender, try again.");
			return;
		}

		System.out.println("Select a year");
		String year = scanner.nextLine();
		if (!isValidYear(year)) {
			System.out.println("Data for this year is not available.");
			return;
		}

		int rankOfAskedYear = getRank(year, name, gender, babyNamesData);
		int rankOfMostRecentYear = getRank(String.valueOf(this.MAX_YEAR), name, gender, babyNamesData);

		System.out.println("The name " + name + ", of gender " + gender + ", had a rank of " + rankOfAskedYear + " in "
				+ year + " and a rank of " + rankOfMostRecentYear + " in " + this.MAX_YEAR);

	}
}
