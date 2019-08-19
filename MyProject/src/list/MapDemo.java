package list;
import java.util.*;
public class MapDemo {
public MapDemo() {
	} 
public static void main(String[] args) {
	Map<String,String> map;
	map = new HashMap<String,String>();
	map.put("name","anubhav");
	map.put("address", "manyata");
	map.put("phone Number", "12345");
	Set<String> s = map.keySet();
    System.out.println(s);
    Collection<String> collection = map.values();
    System.out.println(collection);
}
}
