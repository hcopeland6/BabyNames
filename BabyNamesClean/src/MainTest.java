import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;

import managers.Data;
import managers.FileLoader;
import query_classes.QueryHelper;

class MainTest extends QueryHelper{
	
	FileLoader fl = new FileLoader();
	Map<String, ArrayList<Data>> babyNamesData = fl.loadData();
	
	@Test
	public void testQuery1FunctionalityMale(){
		Data testData = getDataByYear(babyNamesData, "2022", "M");
		assertTrue(testData.getName().equals("Aidan"));
	}
	
	@Test
	public void testQuery1FunctionalityFemale(){
		Data testData = getDataByYear(babyNamesData, "2022", "F");
		assertTrue(testData.getName().equals("Beth"));
	}
	

}
