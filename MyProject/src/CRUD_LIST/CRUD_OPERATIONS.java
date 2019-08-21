package CRUD_LIST;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class CRUD_OPERATIONS {
	private static int id;
	private static String deleteid;
	private static String userid;
	private static String updateid;
	private static String firstName;
	private static String lastName;
	private static double GPA;
	private static int choice;
	private static int k = 10;
	static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Users> UserDetails = new ArrayList<Users>();

	public CRUD_OPERATIONS() {
	}

	public static void main(String[] args) {
		do {
			System.out.println("PRESS 1 TO ADD\r\nPRESS 2 TO VIEW\r\nPRESS 3 TO DELETE\r\nPRESS 4 TO UPDATE");
			System.out.println("ENTER YOUR CHOICE:-");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("ENTER USER DETAILS");
				System.out.println("ENTER USERID");
				id = scanner.nextInt();
				System.out.println("ENTER FIRSTNAME");
				firstName = scanner.next();
				System.out.println("ENTER LASTNAME");
				lastName = scanner.next();
				System.out.println("ENTER GPA");
				GPA = scanner.nextDouble();
				UserDetails.add(new Users(id, firstName, lastName, GPA));
				break;
			case 2:
				Collections.sort(UserDetails);
				System.out.println("---------------------------------------------------------");
				System.out.println("HERE IS THE LIST OF USERS");
				System.out.println(UserDetails.toString());
				break;
			case 3:
				System.out.println("ENTER USERID TO DELETE");
				userid = scanner.next();
				for (int i = 0; i < UserDetails.size(); i++) {
					k = 10;
					Users obj = ((ArrayList<Users>) UserDetails).get(i);
					String compareobj = obj.toString();
					deleteid = Character.toString(compareobj.charAt(k));
					while (true) {
						if (compareobj.charAt(k + 1) == ',') {
							break;
						} else {
							deleteid = deleteid + compareobj.charAt(k + 1);
							k++;
						}

					}
					if (userid.equals(deleteid)) {
						Iterator<Users> iterator = UserDetails.iterator();

						for (int j = 0; j <= i; j++) {
							iterator.next();
						}
						iterator.remove();
					}
				}
				break;
			case 4:
				System.out.println("ENTER USERID TO UPDATE");
				userid = scanner.next();
				System.out.println("ENTER FIRSTNAME");
				firstName = scanner.next();
				System.out.println("ENTER LASTNAME");
				lastName = scanner.next();
				System.out.println("ENTER GPA");
				GPA = scanner.nextDouble();
				for (int i = 0; i < UserDetails.size(); i++) {
					k = 10;
					Users obj = ((ArrayList<Users>) UserDetails).get(i);
					String compareobj = obj.toString();
					updateid = Character.toString(compareobj.charAt(k));
					while (true) {
						if (compareobj.charAt(k + 1) == ',') {
							break;
						} else {
							updateid = updateid + compareobj.charAt(k + 1);
							k++;
						}

					}
					if (userid.equals(updateid)) {
						Iterator<Users> iterator = UserDetails.iterator();

						for (int j = 0; j <= i; j++) {
							iterator.next();
						}
						iterator.remove();
						UserDetails.add(new Users(id, firstName, lastName, GPA));
					}
				}

			}
		} while (true);
	}
}
