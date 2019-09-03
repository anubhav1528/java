package model;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
public class Employee implements Serializable{
	private static final long serialVersionUID = -3684763989120549175L;
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	public String rawString;
	public Employee() {
		super();
	}
	public String toString() {
		try {
			//System.out.println(emp);
			ByteArrayOutputStream baos = new 
					ByteArrayOutputStream(1024);
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			byte[] rawData = baos.toByteArray();
			rawString = new String(Base64.getEncoder().encodeToString(rawData));
			System.out.println(rawString);
		oos.flush();
//			oos.close();
			baos.flush();
//			baos.close();
			
			//System.out.println(emp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rawString;
		// return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
	}

	public Employee getObject(String rawString) throws IOException, ClassNotFoundException {
		System.out.println(rawString+"in getObject");
		byte[] byteArrayFromString = Base64.getDecoder().decode(rawString);
		ByteArrayInputStream bais = new ByteArrayInputStream(byteArrayFromString);
		ObjectInputStream ois = new ObjectInputStream(bais);
		//System.out.println("fine till here");
		Object outputObject = ois.readObject();
		//System.out.println("fine till here");
		System.out.println(outputObject);
		Employee empObj = (Employee)outputObject;
		System.out.println(empObj);
		return empObj;
	}
	public Employee(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
