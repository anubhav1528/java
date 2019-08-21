package Employee_List;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeBO {
	private static Employee empObj;

	public static void printEmployee(ArrayList<Employee> EmpObj, int j) {

		System.out.println("ID NAME DEPARTMENT DATE AGE SALARY");
		for (int i = 0; i < j; i++) {
			empObj = EmpObj.get(i);
			System.out.println(empObj.getId() + " " + empObj.getName() + " " + empObj.getDepartment() + " "
					+ empObj.getDateOfJoining() + " " + empObj.getAge() + " " + empObj.getSalary());
			
		}
	}
}
