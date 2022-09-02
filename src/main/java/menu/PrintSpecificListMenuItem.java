package menu;

import java.util.LinkedList;
import java.util.Scanner;

import IndexProject.Index;
import IndexProject.IndexList;
import IndexProject.Person;

public class PrintSpecificListMenuItem extends MenuItem {
	
	public PrintSpecificListMenuItem() {
		super("4","Print Specific List");
	}
	
	@Override 
	public void execute(Index index,Scanner scanner) {
		String letter=FindLetterOfTheLinkedList(scanner);

		IndexList indexlist=index.FindSpecificIndexList(letter);
		printList(letter,indexlist.getList());
	}
	
	
	private String FindLetterOfTheLinkedList(Scanner scanner) {
		System.out.println("Type the char to see the specific list");
		System.out.print("Type char: ");
		char letter=scanner.next().charAt(0);
		return Character.toString(letter);	
	}
	
	private void printList(String letter,LinkedList<Person>list) {
		listHeader(letter);
		listBody(list);	
	}
	
	private void listHeader(String letter) {
		System.out.println("INDEX: "+letter.toUpperCase());
		System.out.println("Full Name : Mobile Number");
		System.out.println("*************************");
	}
	
	private void listBody(LinkedList<Person>list) {
		if(list.isEmpty()) {
			System.out.println("-");
		}else {
		for(Person str:list) {
			
			System.out.println(str.getFullName()+" : "+str.getPhoneNumber());
			
		}
		System.out.println();
		}
		
	}

}
