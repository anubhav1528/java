package JDBC;

import java.sql.*;

public class ConnectionFactory {
	private static Connection connection = null;
	private static ConnectionFactory connectionFactory;

	private ConnectionFactory() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "root");
	}

	public static ConnectionFactory createConnection() throws SQLException
	{
		if (connectionFactory == null)
		{
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
	public Connection getConnection() throws SQLException
	{
		return connection;
	}
}
