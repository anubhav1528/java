package Exception;

public class Person {
private String FirstName;
private String LastName;
public Person() {
	super();
}
public Person(String firstName, String lastName) {
	super();
	this.FirstName = firstName;
	this.LastName = lastName;
}

public Person createPerson(String firstname,String lastname) throws PersonException {
	this.FirstName = firstname;
	this.LastName = lastname;
	if(Character.isUpperCase(firstname.charAt(0))) {
		if(Character.isUpperCase(lastname.charAt(0))){
			System.out.println(firstname+" "+lastname);
			
		}
		else {
			 throw new PersonException("NOT VALID NAME");
		}
	}
	else {
		     throw new PersonException("NOT VALID NAME");
	}
	return new Person(firstname,lastname);
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
	result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
	return result;
}
@Override
	public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Person other = (Person) obj;
	if (FirstName == null) {
		if (other.FirstName != null)
			return false;
	} else if (!FirstName.equals(other.FirstName))
		return false;
	if (LastName == null) {
		if (other.LastName != null)
			return false;
	} else if (!LastName.equals(other.LastName))
		return false;
	return true;
}


}
