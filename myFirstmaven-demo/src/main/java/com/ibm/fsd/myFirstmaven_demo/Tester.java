package com.ibm.fsd.myFirstmaven_demo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

public class Tester {

	public static void main(String[] args) {
		try {
			org.hibernate.SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(EmployeeList.class).buildSessionFactory();
			Session session = factory.openSession();
			EmployeeList emp = new EmployeeList("ram", "murti", "india", "ram@gg.com", 2);
			session.getTransaction().begin();
			session.persist(emp);
			System.out.println("inserted");
			session.getTransaction().commit();
			@SuppressWarnings({ "rawtypes", "deprecation" })
			javax.persistence.Query query = session.createQuery("from EmployeeList");
			List<EmployeeList> empList = query.getResultList();
			for (EmployeeList e : empList) {
				System.out.println(e);
			}
		} catch (Exception e) {
		}

	}

}
