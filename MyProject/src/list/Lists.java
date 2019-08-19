package list;
import java.util.*;
public class Lists {
public static void main(String[] args) {
	Collection<String> list = new ArrayList<String>();
	list.add("John");
	list.add("John");
	Set<String> set = new HashSet<String>();
	set.add("world");
	set.add("hello");
	list.addAll(set);
	System.out.println(list.toString());
	list.clear();
	System.out.println(list.isEmpty());
	for(String str:list) {
		System.out.println(str);
	}
	Iterator<String> str = list.iterator();
	while(str.hasNext()) {
		list.remove(str.next());
	}
}
}
