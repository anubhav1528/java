package createproduct;

public class Permanent extends Employee {
private int salary;
public Permanent() {
	
}
public Permanent(int salary) {
	super(1,"Anu","Patel");
	this.salary=salary;
}
public String getDetails() {
	return "Employee ID is-"+ID+" Employee Name is-"+FirstName+" "+LastName+" salary is "+salary;
}
public static void main(String[] args) {
	Permanent emp = new Permanent(40000);
	System.out.println(emp.getDetails());
}
}
