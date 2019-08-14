package createproduct;

public class Electronics extends Product {
private String itemName;
public Electronics() {
	
}
public Electronics(String itemName,int price) {
	super(price);
	this.itemName=itemName;
	System.out.println("Electronic Name is:-"+this.itemName+" Price is:-"+this.itemPrice);
}
}
