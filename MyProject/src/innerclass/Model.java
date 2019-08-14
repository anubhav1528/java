package innerclass;

public class Model {
private int length;
private int breadth;
public Model() {
	super();
}
public void outermethod(int x,int y) {  
	this.length=x;
	this.breadth=y;
	System.out.println("OuterMethod is "+length+","+breadth);
}
public class Square {
	private int squareLength;
	private int squareBreadth;
	public Square() {
		super();
	}
	public void innermethod(int x,int y) {
		this.squareLength=x;
		this.squareBreadth=y;
		outermethod(squareLength+1,squareBreadth+1);
		System.out.println("InnerMethod is "+length+","+breadth);
	}
	
}

}
