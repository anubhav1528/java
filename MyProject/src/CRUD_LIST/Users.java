package CRUD_LIST;

public class Users implements Comparable<Object> {
int id;
private String firstName;
private String LastName;
private double GPA;
public Users() {
	super();
}
public Users(int id,String firstName, String lastName, double gPA) {
	super();
	this.id=id;
	this.firstName = firstName;
	LastName = lastName;
	GPA = gPA;
}
@Override
public String toString() {
	return "Users [id=" + id + ", firstName=" + firstName + ", LastName=" + LastName + ", GPA=" + GPA + "]";
}
@Override
public int compareTo(Object obj) {
	// TODO Auto-generated method stub
	
	Users Users=(Users)obj;
	if((this.id==Users.id))
	{
				return 0;
	}
	else if ((this.id>Users.id)) {
		return 1;
	}
	else  {
		return -1;
	}
}
}
