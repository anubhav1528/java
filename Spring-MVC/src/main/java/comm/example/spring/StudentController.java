package comm.example.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@RequestMapping(method = RequestMethod.GET, name = "/showView")
	public String goForm() {
		System.out.println("here");
		return "Student-Form";
	}

	@RequestMapping("/processform")
	public String goView() {
		return "View-Form";
	}

	@RequestMapping("/processFormVersionTwo")
	public String processStudentFormVersionTwo(HttpServletRequest request, Model theModel)

	{
		System.out.println("heretoo");
		String message = "Yo!!" + (request.getParameter("studentName")).toUpperCase();
		theModel.addAttribute("M", message);
		System.out.println(message);
		return "View-Form";
	}
}