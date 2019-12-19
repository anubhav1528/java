package parentPackage.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectionFactory {
	private static Connection connection;
	private static MyConnectionFactory factory = null;

	public MyConnectionFactory() throws SQLException, ClassNotFoundException {  
		connection = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:xe","system","root");
	}

	public static MyConnectionFactory createObject() throws SQLException, ClassNotFoundException {
		if (factory == null) {
			factory = new MyConnectionFactory();
		}
		return factory;
	}

	public Connection getConnection() throws SQLException {
		return connection;
	}
}
