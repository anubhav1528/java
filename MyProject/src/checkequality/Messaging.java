package checkequality;

public class Messaging {
private String message;
private static Messaging messaging;
private Messaging() {
	
}
private Messaging(String message) {
	this.setMessage(message);
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
@Override
public String toString() {
	return "Messaging [message=" + message + "]";
}
public static Messaging createMessagingObject() {
	if(messaging==null) {
		messaging=new Messaging();
	}
	return messaging;
}
public static Messaging createMessaginObject(String message) {
		messaging = new Messaging(message);
	
	return messaging;
}

}
