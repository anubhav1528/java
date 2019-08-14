package createproduct;

public class Product {
	protected static int count;
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	static {
		count=0;
	}
    protected int itemPrice;
    public Product() {
    	
    }
    public Product(int itemPrice) {
    count++;
	this.itemPrice=itemPrice;
    }
}
