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
import Model.League;
import Factory.MyConnFactory;

@WebServlet("/add_league.do")
public class AddLeagueController extends HttpServlet {
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
		BufferedWriter bufferwriter = new BufferedWriter(new FileWriter("out.txt"));
		Scanner scanner = new Scanner(new File("out.txt"));
		while (scanner.hasNextInt()) {
			serialVersionUID = scanner.nextInt();
		}
		System.out.println(serialVersionUID);
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
			
			request.setAttribute("ERROR", errMsgs);
			RequestDispatcher view=request.getRequestDispatcher("add_league.php");
			view.forward(request, response);
			
		}

		if (errMsgs.isEmpty()) {
			request.setAttribute("SUCCESS", new Model.League(title, iYear, season));
			Connection connection = MyConnFactory.getMySqlConnectionforSampledb();
			PreparedStatement pst = connection
					.prepareStatement("insert into league(title,season,year,uid) values(?,?,?,?)");
			pst.setString(1, title);
			pst.setString(2, season);
			pst.setInt(3, iYear);
			pst.setInt(4, serialVersionUID++);
			pst.executeUpdate();
			bufferwriter.write(serialVersionUID);
			bufferwriter.flush();
			bufferwriter.close();
			System.out.println("File write complete! Saved to: " + new File("out.txt").getAbsolutePath());
			RequestDispatcher view = request.getRequestDispatcher("success.view");
			view.forward(request, response);
		} 

	}

}