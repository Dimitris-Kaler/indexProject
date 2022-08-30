package exceptions;

public class EmptyPhoneNumberNotAllowedException extends RuntimeException {
	
	@Override
	public String getMessage(){
		return"Expect phoneNumber for person but got emty value instead.";
	}

}
