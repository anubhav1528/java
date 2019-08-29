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
@WebServlet(urlPatterns = { "/add_employee.view" }, initParams = {
		@WebInitParam(name = "country-list", value = "India,Australia,England") })
public class AddEmployeeServlet extends HttpServlet {
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
			}}
		 else {
			String success = (String) request.getAttribute("SUCCESS");
			if(success!=null){
			out.println(success);}
		}
   
        out.println("<fieldset><legend><h4>ADD EMPLOYEE</h2></legend>");
		out.println("<form action='add_employee.do' method='post'><h4><b>Name-</b><br><input type='text' name='title'><br/>");
		out.println("<h4><b>Password-</b><br><input type='password' name='password'><br/>");
		out.println("<h4><b>Email-</b><br><input type='email' name='email'><br/>");
		out.println("<br>");
		String sList = getServletConfig().getInitParameter("country-list");
		String arrSList[] = sList.split(",");
		out.println("<select name='Country'><option value='Country'>Select Country</option>");
		for (String str : arrSList) {
			out.println("<option value='" + str + "'" + ">" + str + "</option>");
		}
		out.println("</select><br/><hr><input type='submit' value='Add Employee'></form>");
		out.println("<h4><a href='login_employee.view'>View List Of Employee</a>");
		out.println("</fieldset>");
		out.println("</body></html>");
	}
}
