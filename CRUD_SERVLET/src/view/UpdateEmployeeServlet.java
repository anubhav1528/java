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
			out.println(success);
		}
       String name=request.getParameter("name");
        // System.out.println(name);
         String password = request.getParameter("password");
         System.out.println(password);
         int id=Integer.parseInt(request.getParameter("id"));
         String country = request.getParameter("country");
         System.out.println(country);
		out.println("<form action='edit_employee.do?id="+id+"' method='post'>");
		out.println("Name<input type='text' name='title'value="+name+" ><br/>");
		out.println("Password<input type='password' name='passoword' value="+password+"><br/>");
		out.println("Email<input type='email' name='email'><br/>");
		String sList = getServletConfig().getInitParameter("country-list");
		String arrSList[] = sList.split(",");
		out.println("<select name='Country'><option value='Country'>Select Country</option>");
		for (String str : arrSList) {
			if(str.equals(country)) {
				continue;
			}
			out.println("<option value='" + str + "'" + ">" + str + "</option>");
		}
		out.println("</select><br/><input type='submit' value='add league'></form></body></html>");
	out.println("<a href='show_employee.view'>View List Of Employee</a>");
	}
}
