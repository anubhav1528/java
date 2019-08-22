package IOWithObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStream {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		EmployeeForIO employeeobj = new EmployeeForIO("1","Anu","Mumbai");
		FileOutputStream out = new FileOutputStream("employeeForIO.out");
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(employeeobj);
		oos.flush();
		System.out.println("writitng "+employeeobj);
		FileInputStream in = new FileInputStream("employeeForIO.out");
		ObjectInputStream ois = new ObjectInputStream(in);
		employeeobj = (EmployeeForIO)ois.readObject();
		System.out.println("written "+employeeobj);
	}
}
