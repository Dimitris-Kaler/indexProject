package IndexProject;
import java.util.Scanner;

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
				System.out.println("** WELCOME TO INDEX-PROJECT MENU");
				System.out.println("***********************************");
				System.out.println("1:Insert Person");
				System.out.println("2.Delete Person");
				System.out.println("3.Print Index");
				System.out.println("4.Print Specific List");
				System.out.println("5.Exit Program");
				
				int choice =readInt(scanner,1,4);
				
				
				switch (choice) {
				case 1:
					scanner.nextLine();
					System.out.print("Full-Name: ");
					String name=scanner.nextLine();
					System.out.print("Mobile-Number: ");
					String phone=scanner.nextLine();
					
					Person person=new Person(name,phone);
					index.add(person);
					break;
				case 2:
					scanner.nextLine();
					System.out.println("Delete String");
					System.out.print("Give the FullName: ");
					index.delete(scanner.nextLine());
					break;
					
				case 3:
					index.print();
					break;
				case 4:
					System.out.println("Type the char to see the specific list");
					System.out.print("Type char: ");
					index.printSpecificList(scanner.next().charAt(0));
					break;
				case 5:
					System.out.println("Bye Bye see you soon!!");
					exit=true;
					break;
					
					
				}
			}
		}

	}

}
