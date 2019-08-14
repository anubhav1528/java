/**
 * 
 */
package checkequality;

/**
 * @author b4ibmjava29
 *
 */
public class Tester {
	public static void main(String[] args) {
Messaging m = Messaging.createMessaginObject("HELLO");
System.out.println(m);
Messaging m1 = Messaging.createMessaginObject("HELLO");
System.out.println(m==m1);
}}
