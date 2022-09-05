package menu;

import java.io.PrintStream;
import java.util.Scanner;

import IndexProject.Index;
import IndexProject.Exit;

public class ExitProgramMenuItem extends MenuItem {
	private Exit exit;
	
	
	public ExitProgramMenuItem() {
		super("5","Exit The Program");
		exit=new Exit();
	}
	@Override
	public void execute(Index index,Scanner scanner,PrintStream out) {
		System.out.println(message());
		exit.doIt();
	}
	
	private String message() {
		return "Bye Bye see you soon!!";
	}
	


}
