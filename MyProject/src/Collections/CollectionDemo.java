package Collections;
import java.util.*;
public class CollectionDemo {
static Scanner sc = new Scanner(System.in);
private String str[];
private Set set;
public CollectionDemo() throws InputMismatchException{
	System.out.println("Number of elements in the array: ");
	str = new String[sc.nextInt()];
	for(int i =0; i<str.length;i++) {
		System.out.println("Name: ");
		str[i]=sc.next().toString();
				
	}
	set = new HashSet();
	for(String s: str) {
		if(!set.add(s)) {
		System.out.println("Duplicate element found not added in set");
		}
	}
}
public void displayCollection() {
	Iterator i = set.iterator();
	while(i.hasNext()) {
		System.out.println(i.next().toString());
		System.out.println(i.next().toString());
		System.out.println(i.next().toString());
	}
}

}
