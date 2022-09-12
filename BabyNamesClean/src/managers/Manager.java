package managers;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import query_classes.Query1;
import query_classes.Query2;
import query_classes.Query3;

public class Manager {
	
	//This is a comment to prove that the git integration works
	//This is the secondary addon
	//This is a tertiary addon
	
	
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

        System.out.println("Choose an option");
        System.out.println("P Show most popular names for a given year and gender.");
        System.out.println("R  Show rank for a given name, gender, and year.");
        System.out.println("Y  Find the year in which the given name, gender combination was most popular.");
        System.out.println("Q Quit");
        String querySelection = in.nextLine().toUpperCase();
        
        if(querySelection.equals("P")){
            q1.runQ1(babyNamesData);
        } else if(querySelection.equals("R")){
            q2.runQ2(babyNamesData);
        } else if(querySelection.equals("Y")){
            q3.runQ3(babyNamesData);
        } else {
            System.out.println("Goodbye.");
            in.close();
            return;
        }
        
        System.out.println("\n");
        
        //Gotten from https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
        //Copied portion: TimeUnit.SECONDS.sleep(1);
        try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        runBeginningPrompts(babyNamesData);
        
        in.close();
	}
}
