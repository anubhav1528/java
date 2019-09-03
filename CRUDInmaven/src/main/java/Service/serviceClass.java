package Service;

import java.sql.SQLException;
import java.util.List;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;

public class serviceClass implements serviceInterface {
	private EmployeeDao dao = null;

	public serviceClass () throws SQLException {
		super();
		dao = new EmployeeDaoImpl();
	}

	@Override
	public void createEmployee() {

		dao.createEmployee();
	}

	@Override
	public void  getAllEmployees() {

		dao.getAllEmployees();
	}

	@Override
	public void getEmployeeById(int id) {

		dao.getEmployeeById(id);
	}

	@Override
	public void deleteEmployee(int id) {
	 dao.deleteEmployee(id);
		
	}

	@Override
	public void updateEmployee(int id) {
		// TODO Auto-generated method stub
		dao.updateEmployee(id);
	}


}

