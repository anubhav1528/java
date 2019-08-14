package createproduct;

public class CreateProduct {
public static void main(String[] args) {
	Book bookobj1 = new Book("The Narnia",2000);
	System.out.println(Product.count);
	System.out.println(bookobj1.getClass().getName());
	Book bookobj2 = new Book("The Harrypoter",2100);
	System.out.println(Product.count);
	System.out.println(bookobj2.getClass().getName());
	Book bookobj3 = new Book("The Scary",2200);
	System.out.println(Product.count);
	System.out.println(bookobj3.getClass().getName());
	Electronics electricobj1 = new Electronics("Trimmer",4000);
	Electronics electricobj2 = new Electronics("Mobile",5000);
	Electronics electricobj3 = new Electronics("HeadPhone",2000);
	System.out.println(Product.count);
	System.out.println(bookobj1.count);
}
}
