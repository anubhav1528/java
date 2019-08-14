package createproduct;

public class Employee {
protected int ID;
protected String FirstName;
protected String LastName;
public Employee() {

}
public Employee(int ID, String FirstName, String LastName) {
this.ID=ID;
this.FirstName=FirstName;
this.LastName=LastName;
}
public String getDetails() {
	return "Employee ID is-"+ID+"Employee Name is-"+FirstName+" "+LastName;
}
}
