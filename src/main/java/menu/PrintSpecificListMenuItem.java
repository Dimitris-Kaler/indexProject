package menu;

import java.util.Scanner;

import IndexProject.Index;
import IndexProject.Person;

public class PrintSpecificListMenuItem extends MenuItem {
	
	public PrintSpecificListMenuItem() {
		super("4","Print Specific List");
	}
	
	@Override 
	public void execute(Index index,Scanner scanner) {
		System.out.println("Type the char to see the specific list");
		System.out.print("Type char: ");
		char letter=scanner.next().charAt(0);
//		
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		char character=Character.toUpperCase(letter);
		int numberOfLinkedList=alphabet.indexOf(letter);
		System.out.println("Full Name : Mobile Number");
		System.out.println("*************************");
		for(Person str:index.getPersonIndex().get(numberOfLinkedList)) {
			System.out.println(str.getFullName()+" "+str.getPhoneNumber());
			
		}
		System.out.println();
	}

}
