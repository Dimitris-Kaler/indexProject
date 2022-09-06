package IndexProject;

import java.io.PrintStream;
import java.util.Scanner;

import menu.Menu;
import menu.MenuItem;

public class UI {
	 Menu menu;
	 Index index;
	
	
	public UI() {
		menu=new Menu();
		index=new Index();
	}
	public void run() {
		try(Scanner scanner=new Scanner(System.in)){
			boolean exit=false;
			while(!exit) {
				printMenuOptions();
				String choice = parseInputFromCommandLine(scanner);
				MenuItem menuItemSelected=menu.findByCode(choice);
				menuItemSelected.execute(index,scanner,System.out);

			}
		}

	}
	
	private static void printMenuOptions() {
		System.out.println(new Menu().options());

		
	}
	
	private static String parseInputFromCommandLine(Scanner sc) {
		prompt(System.out);
		while(sc.hasNext()) {
			try {
				return validateChoice(sc);
				
			}catch(Exception e) {
				handleException(e);
			}
			finally {
				prompt(System.out);
			}
		}
		return null;
		
	}
	
	private static void handleException(Exception e) {
		System.err.println(e.getMessage());
	}
	
	private static String validateChoice(Scanner sc) {
		String choice = sc.next();
		new CLIMenuChoiceValidator().validate(choice);
		return choice;
	}

	private static void prompt(PrintStream out) {
		out.println("Enter choice: ");
	}
	
	}

