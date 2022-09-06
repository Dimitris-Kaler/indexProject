package IndexProject;

import java.io.PrintStream;
import java.util.Scanner;

import menu.Menu;
import menu.MenuItem;

public class UI {
	private Menu menu;
	private Index index;
	private CLIMenuChoiceValidator cliMenuChoiceValidator;
	
	
	public UI() {
		menu=new Menu();
		index=new Index();
		cliMenuChoiceValidator=new CLIMenuChoiceValidator();
	}
	
	public UI(Menu menu) {
		this();
		this.menu=menu;
	}
	
	
	public void run() {
		try(Scanner scanner=new Scanner(System.in)){
			boolean exit=false;
			while(!exit) {
				printMenuOptions(System.out);
				String choice = parseInputFromCommandLine(scanner,System.out);
				MenuItem menuItemSelected=menu.findByCode(choice);
				menuItemSelected.execute(index,scanner,System.out);

			}
		}

	}
	
	private void printMenuOptions(PrintStream out) {
		out.println(menu.options());		
	}
	
	private String parseInputFromCommandLine(Scanner sc,PrintStream out) {
		prompt(out);
		while(sc.hasNext()) {
			try {
				return validateChoice(sc,out);
				
			}catch(Exception e) {
				System.err.println(e.getMessage());
			}
			finally {
				prompt(out);
			}
		}
		return null;
		
	}
	
//	private static void handleException(Exception e) {
//		System.err.println(e.getMessage());
//	}
//	
	private String validateChoice(Scanner sc,PrintStream out) {
		String choice = sc.next();
		out.println("Choice:"+choice);
		cliMenuChoiceValidator.validate(choice);
		return choice;
	}

	private void prompt(PrintStream out) {
		out.println("Enter choice: ");
	}
	
	}

