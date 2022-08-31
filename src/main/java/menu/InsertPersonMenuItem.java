package menu;

import java.util.Scanner;

import IndexProject.Index;
import IndexProject.Person;

public class InsertPersonMenuItem extends MenuItem {
	
	public InsertPersonMenuItem() {
		super("1","Insert Person");
	}
	
	@Override
	public void execute(Index index,Scanner scanner) {
		scanner.nextLine();
		System.out.print("Full-Name: ");
		String name=scanner.nextLine();
		System.out.print("Mobile-Number: ");
		String phone=scanner.nextLine();
		Person person=new Person(name,phone);
		String fullName=person.getFullName();
		
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		String checkedFullName=fullName.trim();
		String firstLetter=String.valueOf(checkedFullName.charAt(0)).toLowerCase();
		int numberOfLinkedList=alphabet.indexOf(firstLetter);
		index.getPersonIndex().get(numberOfLinkedList).add(person);
		System.out.println("The Person has succesfully added!!");
		
	}

}
