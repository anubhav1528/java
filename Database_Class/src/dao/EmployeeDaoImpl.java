package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import factory.MyConnectionFactory;
import model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private MyConnectionFactory factory = null;
	private Connection connection = null;
	private PreparedStatement pStatement = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
    private int returnint;
	public EmployeeDaoImpl() throws SQLException {
		super();
		factory = MyConnectionFactory.createObject();
		connection = factory.getConnection();
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from employee");
			while (resultSet.next()) {
				list.add(new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Employee empobj = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			resultSet = statement.executeQuery("select * from employee where id=" + id);

			while (resultSet.next()) {
				empobj = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(empobj.toString());
		return empobj;
	}

	@Override
	public void createEmployee(Employee employee) {
		try {
			pStatement = connection.prepareStatement("insert into employee values(?,?,?,?)");
			pStatement.setInt(1, employee.getId());
			pStatement.setString(2, employee.getFirstName());
			pStatement.setString(3, employee.getLastName());
			pStatement.setString(4, employee.getEmail());
			pStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("duplicate id");

			e.printStackTrace();
		} finally {

		}

	}

	@Override
	public int deleteEmployee(int id) {
		try {
			pStatement = connection.prepareStatement("delete from employee where id=?");
			pStatement.setInt(1, id);
			 returnint = pStatement.executeUpdate();
			}

		 catch (SQLException e) {
			System.out.println("NOT VALID ID");

			e.printStackTrace();
		}
return returnint;
	}

	@Override
	public int updateEmployee(Employee employee) {
		try {
			pStatement = connection.prepareStatement("UPDATE employee SET firstname=?,lastname=?,email=? where id=?");
			pStatement.setInt(4, employee.getId());
			pStatement.setString(1, employee.getFirstName());
			pStatement.setString(2, employee.getLastName());
			pStatement.setString(3, employee.getEmail());
			returnint = pStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnint;
	}

}
