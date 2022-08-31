package menu;

import java.util.LinkedList;
import java.util.Scanner;

import IndexProject.Index;
import IndexProject.Person;

public class DeletePersonMenuItem extends MenuItem {
	public DeletePersonMenuItem() {
		super("2","Delete Person");
	}
	
	@Override
	public void execute(Index index,Scanner scanner) {
		String name=findPersonFromName(scanner);
		LinkedList<Person> list=index.FindSpecificLinkedList(name);
		boolean nameExist=list.removeIf(person->person.getFullName().equals(name));
		printTheCorrectMessage(nameExist);
	}
	
	
	private String findPersonFromName(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Delete String");
		System.out.print("Give the FullName: ");
		String name=scanner.nextLine();
		return name;
		
	}
	
	private void printTheCorrectMessage(Boolean nameExist) {
		if(nameExist==false) {
			System.out.println("This String doesnt exist");
		}else {
			System.out.println("Person deleted from the Index!");
		}
		
	}
	

}
