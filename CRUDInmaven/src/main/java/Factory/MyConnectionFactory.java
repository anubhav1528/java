package Factory;

import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.fsd.CRUDInmaven.Model.EmployeeList;

public class MyConnectionFactory {
static SessionFactory factory= null;
	public static SessionFactory createSessionFactory() throws SQLException {
		if (factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EmployeeList.class)
					.buildSessionFactory();
		}
		return factory;
	}
	 
}
