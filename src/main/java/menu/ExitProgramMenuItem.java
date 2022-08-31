package menu;

import java.util.Scanner;

import IndexProject.Index;

public class ExitProgramMenuItem extends MenuItem {
	public ExitProgramMenuItem() {
		super("5","Exit The Program");
	}
	@Override
	public void execute(Index index,Scanner scanner) {
		System.out.println("Bye Bye see you soon!!");
		System.exit(0);
	}
	


}
