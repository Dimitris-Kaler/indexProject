package IndexProject;

import java.io.PrintStream;
import java.util.Scanner;
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
	
	
	public Person() {
		
	}
	
	public Person(String fullName,String phoneNumber) {
		this.fullName=fullName;
		this.phoneNumber=phoneNumber;
		
		
		validatePerson();
		
		
		
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	


	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	
	
//	public Person createPersonToAdd(Scanner scanner,PrintStream out) {
//		Person person=new Person();
//		scanner.nextLine();
//		out.print("Full-Name: ");
//		String name=scanner.nextLine();
//		person.setFullName(name);
//		
//		
//		out.print("Mobile-Number: ");
//		String phone=scanner.nextLine();
//		person.setPhoneNumber(phone);
////		Person person=new Person(name,phone);
//
//		System.out.println(name);
//		return person;
//		
//		
//	}

	
	
	}
	
	
	
	



