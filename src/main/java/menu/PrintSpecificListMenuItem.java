package menu;

import java.util.LinkedList;
import java.util.Scanner;

import IndexProject.Index;
import IndexProject.Person;

public class PrintSpecificListMenuItem extends MenuItem {
	
	public PrintSpecificListMenuItem() {
		super("4","Print Specific List");
	}
	
	@Override 
	public void execute(Index index,Scanner scanner) {
		String letter=FindLetterOfTheLinkedList(scanner);
		LinkedList<Person> list=index.FindSpecificLinkedList(letter);
		printList(letter,list);
	}
	
	
	private String FindLetterOfTheLinkedList(Scanner scanner) {
		System.out.println("Type the char to see the specific list");
		System.out.print("Type char: ");
		char letter=scanner.next().charAt(0);
		return Character.toString(letter);	
	}
	
	private void printList(String letter,LinkedList<Person>list) {
		System.out.println("INDEX: "+letter.toUpperCase());
		System.out.println("Full Name : Mobile Number");
		System.out.println("*************************");
		for(Person str:list) {
			System.out.println(str.getFullName()+" "+str.getPhoneNumber());
			
		}
		System.out.println();
		
	}

}
