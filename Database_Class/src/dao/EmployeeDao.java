package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDao {
	public void createEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int id);

	public int deleteEmployee(int id);
	 
    public int updateEmployee(Employee employee);
}
