package comm.ibm.MyFirstSTSProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class employeeDao {
	
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	/*
	 * public void createConnection() { try { Connection
	 * connection=dataSource.getConnection();
	 * System.out.println(connection.toString()); } catch (SQLException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */
	
	public void createEmployee(employeeClass employee)
	{
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement pst=connection.prepareStatement("insert into Employeetable(id,name) values(?,?)");
			pst.setInt(1, employee.getId());
			pst.setString(2,employee.getName());
			pst.executeUpdate();
			System.out.println("inseerted..!");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from employeetable");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void createeEmployee(employeeClass employee)	{
		System.out.println(employee.getId()+" "+employee.getName());
		String query="insert into Employeetable(id,name) values(?,?)";
		Object obj[]= {employee.getId(),employee.getName()};
		jdbcTemplate.update(query,obj);
		System.out.println(jdbcTemplate);
	}

	public void updateEmployee(int i, String string) {
		String query="update Employeetable set name=? where id=?";
		Object obj[] = {string,i};
		jdbcTemplate.update(query,obj);
		System.out.println(jdbcTemplate);
	}

	public void deleteEmployee(int i) {
		String query="delete from  Employeetable where id=?";
		Object obj[] = {i};
		jdbcTemplate.update(query,obj);
		System.out.println(jdbcTemplate);
		
	}

	public void getAllEmpployee() {
		String query="select * from Employeetable";
		List<Map<String, Object>> employees;
		employees=jdbcTemplate.queryForList(query);
		for (Map<String, Object> employee : employees) {
            
            for (Iterator<Map.Entry<String, Object>> it = employee.entrySet().iterator(); it.hasNext();) {
                Map.Entry<String, Object> entry = it.next();
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.println(key + " = " + value);
            }
             
            System.out.println();
             
        }
 
		
	}

}
