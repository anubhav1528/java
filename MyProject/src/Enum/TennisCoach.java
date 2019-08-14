package Enum;

public class TennisCoach implements Coach {
	private String name;
	private Level level;

	public TennisCoach() {
		super();
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise back volley today..";
	}

	public void creaeteCoach(String name, Level level) {
		this.setName(name);
		this.setLevel(level);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getCoachDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append("Todays workout paln:" + getDailyWorkout() + "\n");
		sb.append("Name of the coach:" + getName());
		sb.append("level of the coach:" + getLevel());
		sb.append("coach's level rank is :" + level.getLevelCode());
		// sb.append("Name of the coach:"+getName());
		return sb.toString();
	}
}
