package CountryAndState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Country implements Comparable<Country> {
	private String Name;
	ArrayList<State> StateList = new ArrayList<State>();

	@Override
	public String toString() {
		return "Country [StateList=" + StateList + "Name=" + Name + "]";
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public Country(String name, ArrayList<State> stateList) {
		super();
		Name = name;
		StateList = stateList;
	}

	public Country() {
		// TODO Auto-generated constructor stub
	}

	public void addState(String stateName) {
		StateList.add(new State(stateName));
	}

	public ArrayList<State> getStateList() {
		Collections.sort(StateList);
		return StateList;
	}

	@Override
	public int compareTo(Country obj) {
		// TODO Auto-generated method stub
		int compare = this.Name.compareTo(obj.Name);
		if (compare > 0) {
			return 1;
		} else if (compare < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
