package JDBC;
import java.sql.*;
import java.util.*;
public class Database {
private static Properties properties=null;
	static {
		properties= new Properties();
		properties.put("URL","jdbc:mysql://localhost:3306/sampledb");
		properties.put("username","root");
		properties.put("password","root");
	}
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection(properties.getProperty("URL"),
		properties.getProperty("username"),properties.getProperty("password"));
		Statement statement = conn.createStatement();
		ResultSet resultset = statement.executeQuery("select * from example");
		System.out.println("id name org");
		while(resultset.next()) {
			System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+resultset.getString(3));
		}
	}

}
