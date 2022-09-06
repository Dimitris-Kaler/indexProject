package IndexProject;
import java.io.PrintStream;
import java.util.Scanner;
import menu.Menu;
import menu.MenuItem;

public class App {
	private static Menu menu=new Menu();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Index index=new Index();
		
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
	
//	public static void acceptChoice(String choice) {
//		validateInBounds(validateInteger(choice));
//	}

//	private static void validateInBounds(int value) {
//		if (value < 1 || value > 5)
//			throw new InvalidMenuChoice(String.valueOf(value));
//	}
//
//	private static int validateInteger(String choice) {
//		try {
//			return Integer.parseInt(choice);
//		} catch (NumberFormatException e) {
//			throw new InvalidMenuChoice(choice);
//		}
//	}

}
