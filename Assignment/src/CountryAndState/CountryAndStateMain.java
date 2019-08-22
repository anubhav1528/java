package CountryAndState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CountryAndStateMain {
	static ArrayList<Country> countryList = new ArrayList<Country>();
	static ArrayList<State> stateTempList = new ArrayList<State>();
	static Scanner scanner = new Scanner(System.in);
	private static String inputtedString;
	private static String countryName = "";
	private static String stateName = "";
	private static int flag = 0;
    static Country countryObj;
	static State stateObj;
	private static int iteration;

	public static void main(String[] args) {
		iteration = scanner.nextInt();
		for (int i = 0; i < iteration; i++) {
			countryName = "";
			stateName = "";
			flag = 0;
			inputtedString = scanner.next();
			for (int j = 0; j < inputtedString.length(); j++) {
				if (inputtedString.charAt(j) == '|') {
					for (int k = j + 1; k < inputtedString.length(); k++) {
						stateName = stateName + inputtedString.charAt(k);
					}
					break;
				}
				countryName = countryName + inputtedString.charAt(j);
			}
			for (int l = 0; l < countryList.size(); l++) {
				countryObj = countryList.get(l);
				if (countryName.equals(countryObj.getName())) {
					countryObj.addState(stateName);
					stateTempList = countryObj.getStateList();
					flag = 1;
				}
			}
			if (flag == 0) {
				countryObj = new Country();
				countryObj.setName(countryName);
				countryObj.addState(stateName);
				stateTempList = countryObj.getStateList();
				countryList.add(countryObj); 
			}
		}
		Collections.sort(countryList);
		System.out.println("Countries and States in ascending order");
		for (int m = 0; m < countryList.size(); m++) {
			countryObj = countryList.get(m);
			stateTempList = countryObj.StateList;
			System.out.println(countryObj.getName());
			for (int n = 0; n < stateTempList.size(); n++) {
                stateObj=stateTempList.get(n);
                System.out.println("-"+stateObj.getStateName());
			}

		}
	}
}
