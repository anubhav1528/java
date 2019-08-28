package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Factory.MyConnFactory;
import Model.EmployeeList;;

/**
 * Servlet implementation class ListLeague
 */
@WebServlet("/show_employee.view")
public class ShowEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, NamingException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Model.EmployeeList> list = new ArrayList<Model.EmployeeList>();
//		list.add(new Model.League("Soccer League", 2009, "Summer"));
//		list.add(new Model.League("Swiming League", 2019, "Summer"));
//		list.add(new Model.League("Basket Ball League", 2009, "Autumn"));
//		list.add(new Model.League("Beach Volley", 2015, "Winter"));
		out.println("<table><tr><td>Title</td><td>Year</td><td>Season</td></tr>");
		Connection connection = MyConnFactory.getMySqlConnectionforSampledb();
		Statement statement = null;
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select id,name,password,country from EmployeeList");

		while (resultSet.next()) {
			list.add(new EmployeeList(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4)));
		}
		System.out.println(list);
		for (Model.EmployeeList l : list) {
			out.println("<tr><td>" + l.getId() + "</td><td>" + l.getName() + "</td><td>"
					+ l.getCountry() + "</td><td>"+"<a href='edit_employee.view?id="+l.getId()+"&name="+l.getName()+"&password="+l.getPassword()+"&country="+l.getCountry()+"'>edit</a></td><td>"+"<a href='deleteemployee.view?id="+l.getId()+"'>delete</a></td></tr>");
		}
		out.println("</table>");
		out.println("<a href='add_employee.view'>Add a employee</a>");

	}

}