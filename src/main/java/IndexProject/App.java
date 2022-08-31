package IndexProject;
import java.util.Scanner;
import exceptions.InvalidMenuChoice;
import menu.Menu;

public class App {
	
	public static int readInt(Scanner sc,int lower,int upper) {
		int choice;
		while(true) {
			System.out.println("Your choice: ");
			if(sc.hasNextInt()) {
				choice=sc.nextInt();
				if(choice<lower||choice>upper) {
					System.out.println("Error: Between "+lower+" and "+upper);
				}
				else 
					return choice;
				
			}else {
				sc.next();
				System.out.println("Invalid input!!");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Index index=new Index();
		
		try(Scanner scanner=new Scanner(System.in)){
			boolean exit=false;
			while(!exit) {
				printMenuOptions();
				String choice = parseInputFromCommandLine(scanner);
				
				if("1".equals(choice)) {
					index.add(scanner);
				}
				if("2".equals(choice)) {
					index.delete(scanner);
					
				}
				if("3".equals(choice)) {
					index.print();
					
				}
				if("4".equals(choice)) {
					index.printSpecificList(scanner);
					
				}
				if("5".equals(choice)) {
					System.out.println("Bye Bye see you soon!!");
					exit=true;
				}

			}
		}

	}
	
	private static void printMenuOptions() {
		System.out.println(new Menu().options());

		
	}
	
	private static String parseInputFromCommandLine(Scanner sc) {
		prompt();
		while(sc.hasNext()) {
			try {
				return validateChoice(sc);
				
			}catch(Exception e) {
				handleException(e);
			}
			finally {
				prompt();
			}
		}
		return null;
		
	}
	
	private static void handleException(Exception e) {
		System.err.println(e.getMessage());
	}
	
	private static String validateChoice(Scanner sc) {
		String choice = sc.next();
		acceptChoice(choice);
		return choice;
	}

	private static void prompt() {
		System.out.println("Enter choice: ");
	}
	
	public static void acceptChoice(String choice) {
		validateInBounds(validateInteger(choice));
	}

	private static void validateInBounds(int value) {
		if (value < 1 || value > 5)
			throw new InvalidMenuChoice(String.valueOf(value));
	}

	private static int validateInteger(String choice) {
		try {
			return Integer.parseInt(choice);
		} catch (NumberFormatException e) {
			throw new InvalidMenuChoice(choice);
		}
	}

}
