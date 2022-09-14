package query_classes;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import managers.Data;

public class Query5 extends QueryHelper{
	//Show the rankings of a name/gender pair within a range of years
	
	Scanner scanner = new Scanner(System.in);
	
	public void runQ5(Map<String, ArrayList<Data>> babyNamesData) {
		System.out.println("Select a name");
		String name = scanner.nextLine();
		name = capitalizeName(name);
		
		System.out.println("Select a gender");
		String gender = scanner.nextLine().toUpperCase();
		if(!isGenderValid(gender)) {
        	System.out.println("Invalid Gender, try again.");
        	return;
        }
		
		System.out.println("Select a start year");
		String minYear = scanner.nextLine();
		
		System.out.println("Select an end year");
		String maxYear = scanner.nextLine();
		
		Map<String, String> yearRanks = new TreeMap<String, String>();
		
		for(int year = Integer.parseInt(minYear); year <= Integer.parseInt(maxYear); year++) {
			yearRanks.put(String.valueOf(year), String.valueOf(getRank(String.valueOf(year), name, gender, babyNamesData)));
		}
		
		System.out.println(toString(yearRanks));
	}
}
