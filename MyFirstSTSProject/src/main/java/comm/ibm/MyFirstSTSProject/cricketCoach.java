package comm.ibm.MyFirstSTSProject;

public class cricketCoach implements coach {
	private fortuneInterface obj;
	public void getDailyRouting() {
		System.out.println("cricket coach");

	}

	public String getFortuneForToday() {
		// TODO Auto-generated method stub
		return obj.getFortune();
	}

}
