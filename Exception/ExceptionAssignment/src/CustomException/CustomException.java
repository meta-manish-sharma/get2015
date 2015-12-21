package CustomException;

public class CustomException extends Exception{
	
	private static final long serialVersionUID = -1574597509869941816L;
	
	public CustomException(String message){
		super(message);
	}
	public CustomException(String message, Throwable cause){
		super(message,cause);
	}

}
