package Tester;

import java.sql.SQLException;

import Service.serviceClass;
import Service.serviceInterface;

public class testerClass {

	public static void main(String[] args) throws SQLException {
		serviceInterface obj = new serviceClass();
		obj.getAllEmployees();
		obj.createEmployee();
		obj.getAllEmployees();
}
}