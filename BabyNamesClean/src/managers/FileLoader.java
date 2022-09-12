package managers;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileLoader {

	private final String PATH_NAME_PREFIX = "/Users/huntercopeland/Desktop/Elon/Year4Sem1/SoftwareDesign/EclipseSD/BabyNames/us_name_data/yob";

	public Map<String, ArrayList<Data>> loadData() {

		Map<String, ArrayList<Data>> dataOfBabyNamesByYear = new HashMap<String, ArrayList<Data>>();

		int num = 1880;
		while (num <= 2022) {
			try {
				File file = new File(PATH_NAME_PREFIX + String.valueOf(num) + ".txt");
				Scanner input = new Scanner(file);
				ArrayList<Data> listOfDataObjs = new ArrayList<>();
				
				while (input.hasNextLine()) {
					Data data = new Data(input.nextLine());
					listOfDataObjs.add(data);
				}
				
				dataOfBabyNamesByYear.put(String.valueOf(num), listOfDataObjs);
				input.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("File IO Failed");
			}
			// increment the year by one
			num++;
		}
		return dataOfBabyNamesByYear;
	}

}
