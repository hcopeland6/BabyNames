package query_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import managers.Data;

public class QueryHelper {
	
	public final int MIN_YEAR = 1880;
	public final int MAX_YEAR = 2022;

	protected int getRank(String year, String name, String gender, Map<String, ArrayList<Data>> babyNamesData) {

		ArrayList<Integer> freqSetMale = getMaleFreqSet(babyNamesData, year);
		ArrayList<Integer> freqSetFemale = getFemaleFreqSet(babyNamesData, year);

		int rank = -1;

		for (Data data : babyNamesData.get(year)) {
			if (data.getName().equals(name)) {
				if (data.getGender().equals(gender)) {
					if (gender.equals("M")) {
						rank = freqSetMale.indexOf(Integer.parseInt(data.getFreq())) + 1;
					} else {
						rank = freqSetFemale.indexOf(Integer.parseInt(data.getFreq())) + 1;
					}
				}
			}
		}

		return rank;
	}

	private ArrayList<Integer> getFemaleFreqSet(Map<String, ArrayList<Data>> babyNamesData, String year) {
		ArrayList<Integer> freqSetFemale = new ArrayList<>();

		for (Data data : babyNamesData.get(year)) {
			int key = Integer.parseInt(data.getFreq());
			if (data.getGender().equals("F")) {
				if (!freqSetFemale.contains(key)) {
					freqSetFemale.add(key);
				}
			}
		}

		Collections.sort(freqSetFemale);
		Collections.reverse(freqSetFemale);

		return freqSetFemale;
	}

	private ArrayList<Integer> getMaleFreqSet(Map<String, ArrayList<Data>> babyNamesData, String year) {
		ArrayList<Integer> freqSetMale = new ArrayList<>();

		for (Data data : babyNamesData.get(year)) {
			int key = Integer.parseInt(data.getFreq());
			if (data.getGender().equals("M")) {
				if (!freqSetMale.contains(key)) {
					freqSetMale.add(key);
				}
			}
		}

		Collections.sort(freqSetMale);
		Collections.reverse(freqSetMale);

		return freqSetMale;
	}

	public Data getDataByYear(Map<String, ArrayList<Data>> babyNamesData, String year, String gender) {
		int tmp = 0;
		Data tmpData = null;

		for (Data data : babyNamesData.get(year)) {
			if (data.getGender().equals(gender)) {
				if (Integer.parseInt(data.getFreq()) > tmp) {
					tmp = Integer.parseInt(data.getFreq());
					tmpData = data;
				}
			}
		}
		return tmpData;
	}

	protected String getFreqByNameAndYear(Map<String, ArrayList<Data>> babyNamesData, String name, String year,
			String gender) {
		String freq = null;

		for (Data data : babyNamesData.get(year)) {
			if (data.getName().equals(name)) {
				if (data.getGender().equals(gender)) {
					freq = data.getFreq();
				}
			}
		}

		return freq;
	}

	protected String[] getYearAndFreqForMostPopularNameGender(Map<String, ArrayList<Data>> babyNamesData, String name,
			String gender) {
		int tmpFreq = 0;
		String year = null;

		for (int i = MIN_YEAR; i <= MAX_YEAR; i++) {
			for (Data data : babyNamesData.get(String.valueOf(i))) {
				if (data.getGender().equals(gender)) {
					if (data.getName().equals(name)) {
						if (Integer.parseInt(data.getFreq()) > tmpFreq) {
							tmpFreq = Integer.parseInt(data.getFreq());
							year = String.valueOf(i);
						}
					}
				}
			}
		}

		String[] yearAndFreq = { year, String.valueOf(tmpFreq) };
		return yearAndFreq;
	}
	
	protected Boolean isGenderValid(String gender) {
		return (gender.equals("M") || gender.equals("F"));
	}
	
	protected String capitalizeName(String name) {
		String newName = name.substring(0, 1).toUpperCase() + name.substring(1);
		return newName;
		
	}
	
	protected Boolean isValidYear(String year) {
		int yearNum = Integer.parseInt(year);
		return (yearNum <= MAX_YEAR && yearNum >= MIN_YEAR);
	}
	
	public String toString(Map<String, String> ranks) {
		
		String result = "";
		
		for(String year : ranks.keySet()) {
			result += "Year: " + year + " Rank: " + ranks.get(year) + "\n";
		}
		
		return result;
	}

}
