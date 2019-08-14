package abstract_class;

public class Monkey implements LivingThings {
	public String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Monkey() {
		
	}
	public Monkey(String name) {
		this.name=name;
	}
	

	@Override
	public void walk() {
		// TODO Auto-generated method stub
	System.out.println("Monkey walks");
	}

}
