package Factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MyConnFactory {
	private static DataSource dataSource = null;
	private static Connection connection = null;

public static Connection getMySqlConnectionforSampledb() throws NamingException, SQLException {
	Context initContext = new InitialContext();
	Object obj = initContext.lookup("java:/comp/env/jdbc/TestDB");
	dataSource=(DataSource)obj;
	connection= dataSource.getConnection();
	return connection;
}

}

