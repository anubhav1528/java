package inheritance;

public class Tester {
	public static void main(String[] args) {
		flyer flyerObj = new BIrd();
		flyerObj.takeOff();
		flyer flyerObj1 = new Superman();
		flyerObj1.takeOff();
	}
}