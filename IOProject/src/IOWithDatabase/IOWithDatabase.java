package IOWithDatabase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

public class IOWithDatabase {
	String[] StringArray = new String[4];
	EmployeeService empobj;
	int index = 0;

	public void split(String source) throws IOException, SQLException {
		empobj = new EmployeeServiceImpl();
		BufferedReader bufferreader;
		bufferreader = new BufferedReader(new FileReader(source));
		String line = bufferreader.readLine();
		while (line != null) {
			StringArray = line.split("\\s");
			empobj.createEmployee(
					new Employee(Integer.parseInt(StringArray[0]), StringArray[1], StringArray[2], StringArray[3]));
			line = bufferreader.readLine();
		}
		bufferreader.close();
	}

	public static void main(String[] args) throws IOException, SQLException {
		IOWithDatabase obj = new IOWithDatabase();
		obj.split("employee.txt");
	}
}
