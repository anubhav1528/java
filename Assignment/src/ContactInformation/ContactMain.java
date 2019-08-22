package ContactInformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ContactMain {
	public static ArrayList<Contact> contactList = new ArrayList<Contact>();
	Contact contactObj;
	private static String name;
	private static String email;
	private static Long mobile;
	private static String address;
	private static int iterator;
	static Scanner scanner = new Scanner(System.in);
	private static Contact contactobj;

public static void main(String[] args) {
	System.out.println("Enter Number Of Contacts");
	iterator=scanner.nextInt();
	for(int i=0; i<iterator;i++) {
		System.out.println("Enter contact"+(i+1)+"details");
		System.out.println("Enter Name");
		name=scanner.next();
		System.out.println("Enter Email");
		email=scanner.next();
		System.out.println("Enter Mobile");
		mobile=scanner.nextLong();
		System.out.println("Enter address");
		address=scanner.next();
		contactList.add(new Contact(name,email,mobile,address));
	}
	System.out.println("Contact List After Sorting by Mobile Number");
	Collections.sort(contactList);
	for(int j=0;j<contactList.size();j++) {
		contactobj = contactList.get(j);
		System.out.println(contactobj.getAddress()+"-"+contactobj.getMobile());
	}
}

}
