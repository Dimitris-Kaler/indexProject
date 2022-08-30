package exceptions;

public class EmptyNameNotAllowedException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Expected name for person but got empty value instead.";
	}

}
