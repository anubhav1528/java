package view;

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
@WebServlet(urlPatterns = { "/edit_employee.view" }, initParams = {
		@WebInitParam(name = "country-list", value = "India,Australia,England") })
public class UpdateEmployeeServlet extends HttpServlet {
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

		@SuppressWarnings("unchecked")
		List<String> err = (List<String>) request.getAttribute("ERROR");
		if (err != null) {
			for (String s : err) {
				out.println("<font color='red'>" + s + "</font><br/>");
			}
		} else {
			String success = (String) request.getAttribute("SUCCESS");
			if(success!=null) {
			out.println(success);}
		}
		String name = request.getParameter("name");
		// System.out.println(name);
		String password = request.getParameter("password");
		System.out.println(password);
		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");

		out.println("<fieldset><legend><h4>UPDATE EMPLOYEE</h2></legend>");
		out.println("<form action='edit_employee.do?id=" + id + "' method='post'>");
		out.println("Name<br><input type='text' name='title'value=" + name + " ><br/>");
		out.println("Password<br><input type='password' name='passoword' value=" + password + "><br/>");
		out.println("Email<br><input type='email' name='email'value=" + email + "><br/>");
		String sList = getServletConfig().getInitParameter("country-list");
		String arrSList[] = sList.split(",");
		out.println("<br>");
		out.println("<select name='Country'><option value='unknown'>Select Country</option>");
		for (String str : arrSList) {
			out.println("<option value='" + str + "'" + ">" + str + "</option>");
		}
		out.println("</select>");
		out.println("<hr>");
		out.println("<input type='submit' value='update employee'></form>");
		out.println("<a href='login_employee.view'>View List Of Employee</a>");
		out.println("<fieldset");
		out.println("</body></html>");
	}
}
