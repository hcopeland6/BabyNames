package managers;
public class Data {
	
	private String name;
	private String gender;
	private String freq;

	public Data(String data) {
		String[] strList = data.split(",");

		name = strList[0];
		gender = strList[1];
		freq = strList[2];
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getFreq() {
		return freq;
	}
}
