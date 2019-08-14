package Exception;

import java.util.*;

public class Tester {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Person[] personarray = new Person[100];
		Person compareperson = null;
		Person Obj = new Person();
		int i = 0;
		int flag = 0;
		try {
			do {
				flag = 0;
				Person person = new Person();
				System.out.println("Enter FirstName");
				String firstname = scanner.next();
				System.out.println("Enter LastName");
				String lastname = scanner.next();
				if (compareperson == null) {
					Obj = person.createPerson(firstname, lastname);
					personarray[i] = Obj;
					System.out.println("First object created");
					compareperson = person;
					i++;
				} else {
					Obj = person.createPerson(firstname, lastname);
					for (int j = 0; j <= i - 1; j++) {
						boolean check = person.equals(personarray[j]);
						if (check == true) {
							System.out
									.println("Person with similar name already exists Give Entry with different Name");
							flag = 1;
							break;
						}
					}
					if (flag == 0) {
						personarray[i] = Obj;
						i++;

					}
				}
			} while (true);
		} catch (PersonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
