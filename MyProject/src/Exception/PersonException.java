package Exception;

public class PersonException extends Throwable{
	
	private static final long serialVersionUID = -6885863078350351668L;
	private String message;

    public PersonException() {
    	super();
    }
    
	public PersonException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
    
    
}
