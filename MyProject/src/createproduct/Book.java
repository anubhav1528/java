package createproduct;

public class Book extends Product{
private String bookName;
public Book() {
	
}
public Book(String bookName,int price) {
	super(price);
	this.bookName=bookName;
	System.out.println("Book Name is:-"+this.bookName+" Price is:-"+this.itemPrice);
}
}
