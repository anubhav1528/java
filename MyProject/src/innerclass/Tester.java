package innerclass;

public class Tester {
public static void main(String[] args){
	Model outerclassobj = new Model();
	outerclassobj.outermethod(1, 2);
    Model.Square squareobj = outerclassobj.new Square();
    squareobj.innermethod(4, 5);
}
}
