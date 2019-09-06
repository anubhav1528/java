package comm.ibm.MyFirstSTSProject;

public class baseballCoach implements coach {
    private String name;
    private String teamName;
	private fortuneInterface obj = new fortuneImpl();
	public void getDailyRouting() {
		System.out.println("HELLO I'M BASEBALL COACH");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getteamName() {
		return teamName;
	}

	public void setteamName(String teamName) {
		this.teamName = teamName;
	}

	public fortuneInterface getObj() {
		return obj;
	}

	public void setObj(fortuneInterface obj) {
		this.obj = obj;
	}

	public String getFortuneForToday() {
		// TODO Auto-generated method stub
	   return   obj.getFortune();
	}

}
