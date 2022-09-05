package IndexProject;

import java.io.PrintStream;
import java.util.Scanner;

public class PersonCLIParser {
	
	public Person parsePerson(Scanner scanner,PrintStream out) {
		out.print("Full-Name: ");
		String name=scanner.nextLine();
		out.print("Mobile-Number: ");
		String phone=scanner.nextLine();
		Person person=new Person(name,phone);

		
		return person;
	}

}
