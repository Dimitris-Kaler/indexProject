package menu;

import java.util.Scanner;

import IndexProject.Index;

public class DeletePersonMenuItem extends MenuItem {
	public DeletePersonMenuItem() {
		super("2","Delete Person");
	}
	
	@Override
	public void execute(Index index,Scanner scanner) {
		scanner.nextLine();
		System.out.println("Delete String");
		System.out.print("Give the FullName: ");
		String name=scanner.nextLine();
	
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		String checkedFullName=name.trim();
		String firstLetter=String.valueOf(checkedFullName.charAt(0)).toLowerCase();
		int numberOfLinkedList=alphabet.indexOf(firstLetter);
		boolean nameExist=index.getPersonIndex().get(numberOfLinkedList).removeIf(person->person.getFullName().equals(name));
		if(nameExist==false) {
			System.out.println("This String doesnt exist");
		}else {
			System.out.println("String deleted!!");
		}
	}

}
