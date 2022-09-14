package managers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import query_classes.Query1;
import query_classes.Query2;
import query_classes.Query3;
import query_classes.Query4;
import query_classes.Query5;
import query_classes.Query6;
import query_classes.Query7;
import query_classes.Query8;

public class Manager {

	FileLoader fl = new FileLoader();

	public void runQueries() {
		Map<String, ArrayList<Data>> babyNamesData = fl.loadData();
		runBeginningPrompts(babyNamesData);
	}

	private void runBeginningPrompts(Map<String, ArrayList<Data>> babyNamesData) {
		Scanner in = new Scanner(System.in);
		Query1 q1 = new Query1();
		Query2 q2 = new Query2();
		Query3 q3 = new Query3();
		Query4 q4 = new Query4();
		Query5 q5 = new Query5();
		Query6 q6 = new Query6();
		Query7 q7 = new Query7();
		Query8 q8 = new Query8();

		System.out.println("Choose an option");
		System.out.println("P Show most popular names for a given year and gender.");
		System.out.println("R  Show rank for a given name, gender, and year.");
		System.out.println("Y  Find the year in which the given name, gender combination was most popular.");
		System.out.println("A  Show all the rankings of a name/gender pair");
		System.out.println("B  Show the rankings of a name/gender pair within a range of years");
		System.out.println(
				"C  Compare the rank of one name/gender pair in a specific year to that of their rank in next closest year");
		System.out.println("D  Give the average rank of a name/gender pair in a range of years");
		System.out.println(
				"E  Give the most popular letter for a specific gender, along with all the names that start with that letter.");

		System.out.println("Q Quit");
		String querySelection = in.nextLine().toUpperCase();

		if (querySelection.equals("P")) {
			q1.runQ1(babyNamesData);
		} else if (querySelection.equals("R")) {
			q2.runQ2(babyNamesData);
		} else if (querySelection.equals("Y")) {
			q3.runQ3(babyNamesData);
		} else if (querySelection.equals("A")) {
			q4.runQ4(babyNamesData);
		} else if (querySelection.equals("B")) {
			q5.runQ5(babyNamesData);
		} else if (querySelection.equals("C")) {
			q6.runQ6(babyNamesData);
		} else if (querySelection.equals("D")) {
			q7.runQ7(babyNamesData);
		} else if (querySelection.equals("E")) {
			q8.runQ8(babyNamesData);
		} else if (querySelection.equals("Q")) {
			System.out.println("Goodbye.");
			in.close();
			return;
		} else {
			System.out.println("Please enter a valid letter. Try again.");
		}

		System.out.println("\n");

		// Gotten from
		// https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
		// Copied portion: TimeUnit.SECONDS.sleep(1);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		runBeginningPrompts(babyNamesData);

		in.close();
	}
}
