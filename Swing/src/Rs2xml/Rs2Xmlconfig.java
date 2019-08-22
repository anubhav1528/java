package Rs2xml;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import factory.MyConnectionFactory;

public class Rs2Xmlconfig {
	private MyConnectionFactory factory;
	private Connection connection;
	public Rs2Xmlconfig() throws SQLException {
		super();
		factory = MyConnectionFactory.createObject();
		connection = factory.getConnection();
	}
	
	public ResultSet getAllEmployee() throws SQLException {
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from employee");
		return rs;
}
}
