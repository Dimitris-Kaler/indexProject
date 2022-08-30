package exceptions;

public class DigitsInTheNameNotAllowedException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Expect name for person without digits but got with digits instead.";
	}

}
