package dao;

import java.util.List;



public interface EmployeeDao {
	public void createEmployee();

	public void getAllEmployees();

	public void getEmployeeById(int id);

	public void deleteEmployee(int id);
	 
    public void  updateEmployee(int id);
}
