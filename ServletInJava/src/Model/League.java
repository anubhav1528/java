package Model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.Serializable;

public class League implements Serializable {

	public static int serialVersionUID = 100;
	private String leagueTitle;
	private int leagueYear;
	private String leagueSeason;

	public League() {
		super();
	}

	public League(String leagueTitle, int leagueYear, String leagueSeason) {
		super();
		this.leagueTitle = leagueTitle;
		this.leagueYear = leagueYear;
		this.leagueSeason = leagueSeason;
	}

	public String getLeagueTitle() {
		return leagueTitle;
	}

	public void setLeagueTitle(String leagueTitle) {
		this.leagueTitle = leagueTitle;
	}

	public int getLeagueYear() {
		return leagueYear;
	}

	public void setLeagueYear(int leagueYear) {
		this.leagueYear = leagueYear;
	}

	public String getLeagueSeason() {
		return leagueSeason;
	}

	public void setLeagueSeason(String leagueSeason) {
		this.leagueSeason = leagueSeason;
	}

}