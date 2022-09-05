package exceptions;

public class EmptyLetterIndexListNotAllowedException extends RuntimeException {
	
	@Override
	public String getMessage(){
		return "Expected char for indexlist letter but got empty String instead.";
		
	}

}
