package IndexProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.DigitsInTheNameNotAllowedException;
import exceptions.EmptyNameNotAllowedException;
import exceptions.NullNameNotAllowedException;
import exceptions.NullPhoneNumberNotAllowedException;
import exceptions.PhoneNumberNotMatchedException;
import exceptions.EmptyPhoneNumberNotAllowedException;


public class Person {
	
	private String fullName;
	
	private String phoneNumber;
	
	public Person(String fullName,String phoneNumber) {
		this.fullName=fullName;
		this.phoneNumber=phoneNumber;
		
		
		validatePerson();
		
		
		
		
		
		
	}

	public String getFullName() {
		return fullName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	
	private void validatePerson() {
		validateFullName();
		validatePhoneNumber();
	}
	
	
	private void validateFullName() {
		validateFullNameNullValue();
		validateFullNameEmptyValue();
		validateFullNameIfContainsDigits();
	}
	
	private void validateFullNameNullValue(){
		if(this.fullName==null) {
			throw new NullNameNotAllowedException();
		}
		
	};
	
	private void validateFullNameEmptyValue() {
		if("".equals(fullName)) {
			throw new EmptyNameNotAllowedException();
		}
	}
	
	private void validateFullNameIfContainsDigits() {
		    for(char ch : fullName.toCharArray()){
		        if(Character.isDigit(ch)){
		            throw new DigitsInTheNameNotAllowedException();
		        }
		    }

		}
	private void validatePhoneNumber() {
		validatePhoneNumberNullValue();
		validatePhoneNumberEmptyValue();
		validatePhoneNumberWithRegex();
	}
	
	
	private void validatePhoneNumberNullValue() {
		if(phoneNumber==null) {
			throw new NullPhoneNumberNotAllowedException();
		}
	}
	
	
	private void validatePhoneNumberEmptyValue() {
		
		if("".equals(phoneNumber)) {
			throw new EmptyPhoneNumberNotAllowedException();
			
		}

	}
	
	private void validatePhoneNumberWithRegex() {
		Pattern pattern = Pattern.compile("(0|91)?[6-9][0-9]{9}");
		Matcher matcher=pattern.matcher(phoneNumber);
		if(!matcher.matches())
			throw new PhoneNumberNotMatchedException();
		

	}
	}
	
	
	
	



