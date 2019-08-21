package PasswordValidation;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class UserMainCode {
	private static Pattern pattern;
	  private static Matcher matcher;

	  private static final String PASSWORD_PATTERN = 
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,200})";
public static boolean checkpassword(String password) {
	pattern = Pattern.compile(PASSWORD_PATTERN);
	matcher = pattern.matcher(password);
	  return matcher.matches();
}
}
