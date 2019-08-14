package Line_Model;

public class Tester {
public static void main(String[] args) {
	Model model=new Line(0,10);
	Model model1 = new Line(5,20);
	System.out.println(model.isGreater(model1));
	System.out.println(model.isLesser(model1));
	System.out.println(model.isEqual(model1));
}
}
