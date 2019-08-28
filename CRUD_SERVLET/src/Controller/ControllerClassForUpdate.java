package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.EmployeeList;
import Factory.MyConnFactory;

@WebServlet("/edit_employee.do")
public class ControllerClassForUpdate extends HttpServlet {
	private int serialVersionUID;

	private String Country, Name, Password;
	private List<String> errMsgs;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doProcess(request, response);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NamingException, SQLException {
		BufferedWriter bufferwriter = new BufferedWriter(new FileWriter("out.txt"));
		Scanner scanner = new Scanner(new File("out.txt"));
		while (scanner.hasNextInt()) {
			serialVersionUID = scanner.nextInt();
		}
		System.out.println(serialVersionUID);
		errMsgs = new LinkedList<String>();
		Country = request.getParameter("Country");
		if (Country.equals("Select Country")) {
			errMsgs.add("please select a valid Country.");
		}


		Name = request.getParameter("title");
	 Password=request.getParameter("password");
    int id = Integer.parseInt(request.getParameter("id"));
		if (Name.toString().length() < 5) {
			errMsgs.add("Name is too short.");
		}
		if(!errMsgs.isEmpty())
		{
			
			request.setAttribute("ERROR", errMsgs);
			RequestDispatcher view=request.getRequestDispatcher("edit_emloyee.view");
			view.forward(request, response);
			
		}

		if (errMsgs.isEmpty()) {
			
			Connection connection = MyConnFactory.getMySqlConnectionforSampledb();
			PreparedStatement pst = connection
					.prepareStatement("update  EmployeeList set name=?,password=?,country=? where id="+id);
			pst.setString(1, Name);
			pst.setString(2, Password);
			pst.setString(3, Country);
			pst.executeUpdate();
			bufferwriter.write(serialVersionUID);
			bufferwriter.flush();
			bufferwriter.close();
			System.out.println("File write complete! Saved to: " + new File("out.txt").getAbsolutePath());
			request.setAttribute("SUCCESS", "Record Saved Successfully");
			RequestDispatcher view=request.getRequestDispatcher("show_employee.view");
			view.forward(request, response);
		} 

	}

}
