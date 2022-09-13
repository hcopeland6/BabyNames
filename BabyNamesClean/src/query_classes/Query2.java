package query_classes;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import managers.Data;

public class Query2 extends QueryHelper{
	
	Scanner scanner = new Scanner(System.in);
	
	public void runQ2(Map<String, ArrayList<Data>> babyNamesData) {
		System.out.println("Select a name");
        String name = scanner.nextLine();
        name = capitalizeName(name);
        
        System.out.println("Select a gender");
        String gender = scanner.nextLine().toUpperCase();
        if(!isGenderValid(gender)) {
        	System.out.println("Invalid Gender, try again.");
        	return;
        }
        
		System.out.println("Select a year");
        String year = scanner.nextLine();
        if(!isValidYear(year)) {
        	System.out.println("Data for this year is not available.");
        	return;
        }
        
        int rank = getRank(year, name, gender, babyNamesData);
        String freq = getFreqByNameAndYear(babyNamesData, name, year, gender);  
        
        printQ2Data(rank, name, gender, year, freq);
	}
	
	private void printQ2Data(int rank, String name, String gender, String year, String freq) {
		if(rank == -1) {
            System.out.println("Name " + name + " was not found or is invalid.");
        } else {
             System.out.println("The name " + name + ", gender " + gender + ", in the year " + year +
                    ", occurred with frequency " + freq + ", and rank " + rank + " in the " + gender + " group.");

        }
	}
}
