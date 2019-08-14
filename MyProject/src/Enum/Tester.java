package Enum;

import static java.lang.System.*;
import java.util.*;

public class Tester {

	private static Scanner scanner = new Scanner(in);

	public static void main(String[] args) {
		String name = null;
		try {
			System.out.println("coach name:");
			name = scanner.next();
			TennisCoach myCoach = new TennisCoach();
			myCoach.creaeteCoach(name, Level.MEDIUM);
			out.println(myCoach.getCoachDetails().toString());
		} catch (InputMismatchException e) {
			e.printStackTrace();
			err.println(e.toString());
		}
	}
}
