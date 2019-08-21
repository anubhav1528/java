package PasswordValidation;

import java.util.Scanner;

public class UserMainCodeMain {
	private static String password;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while(true) {
		password = scanner.next();
		boolean check=UserMainCode.checkpassword(password);
		if(check==true) {
			System.out.println("VALID PASSWORD");
		}
		else {
			System.out.println("INVALID PASSWORD");
		}
	}}
}
