package menu;

import java.io.PrintStream;
import java.util.Scanner;

import IndexProject.Index;

public interface MenuItemCommand {
	
	public void execute(Index index,Scanner scanner,PrintStream out);

}
