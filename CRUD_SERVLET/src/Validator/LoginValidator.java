package Validator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddLeagueViewServlet
 */
@WebServlet(urlPatterns = { "/login_employee.view" }, initParams = {
		@WebInitParam(name = "country-list", value = "India,Australia,England") })
public class LoginValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	@SuppressWarnings("null")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("<fieldset><legend><h4>LOGIN</h2></legend>");
		out.println(
				"<form action='show_employee.view' method='post'><h4><b>Name-</b><br><input type='text' name='title'><br/>");
		out.println("<h4><b>Password-</b><br><input type='password' name='password'><br/>");
		out.println("<hr><input type='submit' value='Login'></form>");
		out.println("</fieldset>");
		out.println("</body></html>");
	}
}
