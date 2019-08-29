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

@WebServlet("/check.do")
public class ControllerClass extends HttpServlet {
	private int serialVersionUID;

	private String season, title, year;
	private int iYear;
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
		errMsgs = new LinkedList<String>();
		season = request.getParameter("season");
		if (season.equals("Unknmown")) {
			errMsgs.add("please select a valid season.");
		}

		year = request.getParameter("year");
		try {
			iYear = Integer.parseInt(year);

		} catch (Exception e) {
			// TODO: handle exception
			errMsgs.add("year must be numeric");
		}

		title = request.getParameter("title");
		if (title.toString().length() < 5) {
			errMsgs.add("title is too short.");
		}
		if(!errMsgs.isEmpty())
		{
			System.out.println("In Error");
			request.setAttribute("ERROR", errMsgs);
			RequestDispatcher view=request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
			
		}

		if (errMsgs.isEmpty()) {
			request.setAttribute("SUCCESS", "RECORD SAVED SUCCESSFULLY");
			RequestDispatcher view=request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		} 

	}

}