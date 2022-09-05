package menu;

import java.io.PrintStream;
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
	public void execute(Index index,Scanner scanner,PrintStream out) {
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
		System.out.println(listHeader(letter));
		System.out.println(listBody(list));	
	}
	
	private String listHeader(String letter) {
		return "INDEX: "+letter.toUpperCase()+"\nFull Name : Mobile Number\n*************************";
	}
	
	private String listBody(LinkedList<Person>list) {
		String personList="";
		if(list.isEmpty()) {
			return "-";
		}else {
		for(Person str:list) {
			personList+=str.getFullName()+" : "+str.getPhoneNumber()+"\n";
			
			
		}
		return personList;
		}
		
		
	}

}
