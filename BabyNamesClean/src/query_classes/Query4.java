package query_classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import managers.Data;

public class Query4 extends QueryHelper{
	//Show all the rankings of a name/gender pair
	
	Scanner scanner = new Scanner(System.in);
	
	public void runQ4(Map<String, ArrayList<Data>> babyNamesData) {
		System.out.println("Select a name");
		String name = scanner.nextLine();
		name = capitalizeName(name);
		
		System.out.println("Select a gender");
		String gender = scanner.nextLine().toUpperCase();
		if(!isGenderValid(gender)) {
        	System.out.println("Invalid Gender, try again.");
        	return;
        }
		
		Map<String, String> yearRanks = new TreeMap<String, String>();
		
		for(int year = this.MIN_YEAR; year <= this.MAX_YEAR; year++) {
			yearRanks.put(String.valueOf(year), String.valueOf(getRank(String.valueOf(year), name, gender, babyNamesData)));
		}
		
		System.out.println(toString(yearRanks));
	}
	

	

}
