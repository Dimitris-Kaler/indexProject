package menu;

import java.util.LinkedList;
import java.util.Scanner;

import IndexProject.Index;
import IndexProject.IndexList;
import IndexProject.Person;

public class InsertPersonMenuItem extends MenuItem {
	
	public InsertPersonMenuItem() {
		super("1","Insert Person");
	}
	
	@Override
	public void execute(Index index,Scanner scanner) {
		Person person=createPersonToAdd(scanner);
		IndexList indexli=index.FindSpecificIndexList(person.getFullName());
		indexli.getList().add(person);
		System.out.println("The Person has succesfully added!!");
		
	}
	
	private Person createPersonToAdd(Scanner scanner) {
		scanner.nextLine();
		System.out.print("Full-Name: ");
		String name=scanner.nextLine();
		System.out.print("Mobile-Number: ");
		String phone=scanner.nextLine();
		Person person=new Person(name,phone);
		String fullName=person.getFullName();
		
		return person;
		
		
	}

}