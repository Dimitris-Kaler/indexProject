package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import exceptions.InvalidMenuItemCode;

public class Menu {
	private List<MenuItem>menu;
	
	
	public Menu() {
		menu=new ArrayList<MenuItem>();
		menu.add(new InsertPersonMenuItem());
		menu.add(new DeletePersonMenuItem());
		menu.add(new PrintIndexMenuItem());
		menu.add(new PrintSpecificListMenuItem());
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
		
		System.out.println(code);
			
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
