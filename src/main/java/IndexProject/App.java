package IndexProject;
import java.util.Scanner;
import exceptions.InvalidMenuChoice;

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
				
				if("1".contentEquals(choice)) {
					scanner.nextLine();
					System.out.print("Full-Name: ");
					String name=scanner.nextLine();
					System.out.print("Mobile-Number: ");
					String phone=scanner.nextLine();
					Person person=new Person(name,phone);
					index.add(person);
				}
				if("2".equals(choice)) {
					scanner.nextLine();
					System.out.println("Delete String");
					System.out.print("Give the FullName: ");
					index.delete(scanner.nextLine());
					
				}
				if("3".equals(choice)) {
					index.print();
					
				}
				if("4".equals(choice)) {
					System.out.println("Type the char to see the specific list");
					System.out.print("Type char: ");
					index.printSpecificList(scanner.next().charAt(0));
					
				}
				if("5".contentEquals(choice)) {
					System.out.println("Bye Bye see you soon!!");
					exit=true;
				}

			}
		}

	}
	
	private static void printMenuOptions() {
		System.out.println("** WELCOME TO INDEX-PROJECT MENU");
		System.out.println("***********************************");
		System.out.println("1:Insert Person");
		System.out.println("2.Delete Person");
		System.out.println("3.Print Index");
		System.out.println("4.Print Specific List");
		System.out.println("5.Exit Program");
		
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
