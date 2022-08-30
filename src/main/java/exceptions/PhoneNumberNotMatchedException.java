package exceptions;

public class PhoneNumberNotMatchedException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Expect phoneNumber to match to pattern but got false instead.";
	}
	
	

}
