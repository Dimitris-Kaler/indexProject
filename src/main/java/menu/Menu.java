package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import exceptions.InvalidMenuItemCode;

public class Menu {
	private List<MenuItem>menu;
	
	
	public Menu() {
		menu=new ArrayList<MenuItem>();
		menu.add(new MenuItem("1","Insert Person"));
		menu.add(new MenuItem("2","Delete Person"));
		menu.add(new MenuItem("3","Print Index"));
		menu.add(new MenuItem("4","Print Specific List"));
		menu.add(new ExitProgramMenuItem());
		
;
		}
	
	public String options() {
		return header()+menuOptionsAsString();
	}
	
	public MenuItem findByCode(String code) {
		for(MenuItem mi:menu) 
			if(mi.getCode().equals(code)) 
				return mi;
			
		throw new InvalidMenuItemCode();
	}
	
	private String header() {
		return "WELCOME TO INDEX-PROJECT MENU\n"+
				"***********************************\n";
		
	}

	private String menuOptionsAsString() {
		return menu.stream()
			.map(mi -> mi.toString())
			.collect(Collectors.joining("\n"));
	}

}
