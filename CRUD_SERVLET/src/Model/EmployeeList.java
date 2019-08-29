package Model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

public class EmployeeList {

	public static int serialVersionUID = 100;
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String Name;
	private String Email;
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	private String Password;
	private String Country;

	public EmployeeList() {
		super();
	}

	public EmployeeList(int id,String Name, String Password, String Country,String Email) {
		super();
		this.id=id;
		this.Name = Name;
		this.Password = Password;
		this.Country = Country;
		this.Email=Email;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}

}

