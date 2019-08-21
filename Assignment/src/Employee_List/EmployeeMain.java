package Employee_List;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;



public class EmployeeMain {
	static Scanner scanner = new Scanner(System.in);
	private static int id=1;
	private static String name;
	private static String department;
	private static Date dateOfJoining;
	private static int age;
    private static  int salary;
    private static String strDate;
    private static int i=1;
    private static int j;
    private static int choice;
    private static Employee empObj;
    private static EmployeeBO empboobj;
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static ArrayList<Employee> EmpDetails = new ArrayList<Employee>();
	public EmployeeMain() {
		super();
	}
	public static void main(String[] args) {
		System.out.println("Enter the number of employees");
		j=scanner.nextInt();
		System.out.println("ENTER THE DETAILS OF EMPLOYEES");
	for(int k=0;k<j;k++) {
		
		System.out.println("Enter the detail for Employee "+i);
		name=scanner.next();
		department=scanner.next();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        strDate=scanner.next();
		try {
			dateOfJoining = simpleDateFormat.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		age=scanner.nextInt();
		salary=scanner.nextInt();
		EmpDetails.add(new Employee(id,name,department,dateOfJoining,age,salary));
		i++;
		id++;
	}
	System.out.println("1.Sort employee by salary\r\n2.Sort employee by Age and Date\r\nEnter you choice");
	choice=scanner.nextInt();
	switch(choice) {
	case 1:
		Collections.sort(EmpDetails);
		EmployeeBO.printEmployee(EmpDetails,j);
		break;
	case 2:
		Collections.sort(EmpDetails,new SortyByAge());
		EmployeeBO.printEmployee(EmpDetails,j);
	}}
}
