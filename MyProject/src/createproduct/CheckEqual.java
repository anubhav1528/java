package createproduct;

public class CheckEqual {
	public static void main(String[] args) {
		Account obj1 = new Account("Anubhav",40000);
		Account obj2 = new Account("Anubhav",40000);
		Account obj3 = new Account();
		Account obj4 = new Account();
		System.out.println(obj1.checkEquality(obj2));
		System.out.println(obj1.equals(obj2));
	}
}
