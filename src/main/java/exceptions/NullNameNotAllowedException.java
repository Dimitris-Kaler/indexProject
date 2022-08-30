package exceptions;

public class NullNameNotAllowedException extends RuntimeException {
	
	public String getMessage() {
		return "Expected name for person but got null name instead.";
		
	}

}
