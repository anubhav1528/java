package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ibm.fsd.CRUDInmaven.Model.EmployeeList;

public class EmployeeDaoImpl implements EmployeeDao {
	private SessionFactory factory = null;

	public EmployeeDaoImpl() throws SQLException {
		super();
		factory = Factory.MyConnectionFactory.createSessionFactory();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void getAllEmployees() {
		try {

			// start a transaction
			Session session = factory.openSession();
			session.beginTransaction();

			// query EmployeeLists
			List<EmployeeList> theEmployeeLists = session.createQuery("from EmployeeList").getResultList();

			// display the EmployeeLists
			displayEmployeeLists(theEmployeeLists);

			// query EmployeeLists: lastName='Doe'
			Query query = session.createQuery("from EmployeeList s where s.name=:lName");
			query.setParameter("lName", "Doe");
			theEmployeeLists = query.getResultList();
			// displayEmployeeLists(theEmployeeLists);
			// display the EmployeeLists
			System.out.println("\n\nEmployeeLists who have last name of Doe");
			displayEmployeeLists(theEmployeeLists);

			// query EmployeeLists: lastName='Doe' OR firstName='Daffy'
//			theEmployeeLists = session.createQuery("from EmployeeList s where" + " s.lastName='Doe' OR s.firstName='Daffy'")
//					.getResultList();

//			System.out.println("\n\nEmployeeLists who have last name of Doe OR first name Daffy");
//			displayEmployeeLists(theEmployeeLists);

			// query EmployeeLists where email LIKE '%gmail.com'
			theEmployeeLists = session.createQuery("from EmployeeList s where" + " s.email LIKE '%gmail.com'").getResultList();

			System.out.println("\n\nEmployeeLists whose email ends with gmail.com");
			displayEmployeeLists(theEmployeeLists);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			
		}
	}

	private static void displayEmployeeLists(List<EmployeeList> theEmployeeLists) {
		for (EmployeeList tempEmployeeList : theEmployeeLists) {
			System.out.println(tempEmployeeList);
		}
	}
	@Override
	public void getEmployeeById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createEmployee() {
		try {
			Session session = factory.openSession();
			// create a EmployeeList object
			System.out.println("Creating new EmployeeList object...");
			EmployeeList tempEmployeeList = new EmployeeList("Paul", "Doe", "india", "paul@luv2code.com", 2);

			// start a transaction
			session.beginTransaction();

			// save the EmployeeList object
			System.out.println("Saving the EmployeeList...");
			session.save(tempEmployeeList);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			
		}
	}

	@Override
	public void deleteEmployee(int id) {
		try {
			int EmployeeListId = 11;

			// now get a new session and start transaction
			Session session = factory.openSession();
			session.beginTransaction();

			// retrieve EmployeeList based on the id: primary key
			System.out.println("\nGetting EmployeeList with id: " + EmployeeListId);

			EmployeeList myEmployeeList = session.get(EmployeeList.class, EmployeeListId);

			// delete the EmployeeList
			System.out.println("Deleting EmployeeList: " + myEmployeeList);
			session.delete(myEmployeeList);

			/*
			 * // delete EmployeeList id=2 System.out.println("Deleting EmployeeList id=2");
			 * 
			 * session.createQuery("delete from EmployeeList where id=2").executeUpdate();
			 */
			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}

	@Override
	public void updateEmployee(int id) {

	}

}
