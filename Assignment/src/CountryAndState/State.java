package CountryAndState;

public class State implements Comparable<State> {
private String stateName;
	public State(String stateName) {
		// TODO Auto-generated constructor stub
		this.stateName=stateName;
	}
	public String getStateName() {
		return stateName;
	}
	@Override
	public String toString() {
		return "State [stateName=" + stateName + "]";
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	@Override
	public int compareTo(State stateobj) {
		// TODO Auto-generated method stub
		int compare = this.stateName.compareTo(stateobj.stateName);
		if(compare>0)
		{
					return 1;
		}
		else if (compare<0) {
			return -1;
		}
		else  {
			return 0;
		}
	}

}
