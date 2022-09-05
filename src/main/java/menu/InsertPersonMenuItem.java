package menu;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

import IndexProject.Index;
import IndexProject.IndexList;
import IndexProject.Person;
import IndexProject.PersonCLIParser;

public class InsertPersonMenuItem extends MenuItem {
	PersonCLIParser parser;
	
	public InsertPersonMenuItem() {
		this(new PersonCLIParser());
	}
	public InsertPersonMenuItem(PersonCLIParser parser) {
		super("1","Insert Person");
		this.parser=parser;
	}
	
	@Override
	public void execute(Index index,Scanner scanner,PrintStream out) {
		scanner.nextLine();
		try {
		Person person=parser.parsePerson(scanner,out);
		IndexList indexli=index.FindSpecificIndexList(person.getFullName());
		indexli.addPerson(person);
		out.println("The Person has succesfully added!!");
		}catch(Exception e) {
			if(e.getMessage()!=null)
				out.println(e.getMessage());
			else
				out.println("Unexpected Error: "+e.getClass().toString());
		}
		
	}
	
//	private Person createPersonToAdd(Scanner scanner,PrintStream out) {
////		scanner.nextLine();
//		out.print("Full-Name: ");
//		String name=scanner.nextLine();
//		out.print("Mobile-Number: ");
//		String phone=scanner.nextLine();
//		Person person=new Person(name,phone);
//
//		
//		return person;
//		
//		
//	}

}