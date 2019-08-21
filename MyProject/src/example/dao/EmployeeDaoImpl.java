package comm.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import comm.example.factory.MyConnectionFactory;
import comm.example.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private MyConnectionFactory factory=null;
	private Connection connection=null;
	private PreparedStatement pStatement=null;
	private Statement statement=null;
	private ResultSet resultSet=null;
	

	public EmployeeDaoImpl() throws SQLException {
		super();
		factory=MyConnectionFactory.createObject();
		connection=factory.getConnection();
	}

	

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list=new ArrayList<Employee>();
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery("select * from employee");
			while(resultSet.next())
			{
				list.add(new Employee(resultSet.getInt(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4)));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void createEmployee(Employee employee) {
	try {
		pStatement=connection.prepareStatement("insert into employee values(?,?,?,?)");
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
