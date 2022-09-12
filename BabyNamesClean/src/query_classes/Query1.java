package query_classes;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import managers.Data;

public class Query1 extends QueryHelper{

	Scanner scanner = new Scanner(System.in);
	
	public void runQ1(Map<String, ArrayList<Data>> babyNamesData) {
		System.out.println("Select a year");
        String year = scanner.nextLine();

        System.out.println("Select a gender");
        String gender = scanner.nextLine().toUpperCase();
        
        Data dataToBeFormatted = getDataByYear(babyNamesData, year, gender);
        
        printQ1Data(dataToBeFormatted, year, gender);
	}
	
	private void printQ1Data(Data dataToBeFormatted, String year, String gender) {
		String name = dataToBeFormatted.getName();
		String freq = dataToBeFormatted.getFreq();
		
		String formattedData = "The name " + name + ", gender " + gender + ", in the year " + year +
                ", occurred the most with frequency " + freq + ".";
		
		System.out.println(formattedData);
	}

	
	
	
	
}
