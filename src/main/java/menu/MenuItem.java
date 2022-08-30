package menu;

public class MenuItem {

	private String code;
	private String description;
	
	
	public MenuItem(String code,String description) {
		this.code=code;
		this.description=description;
	}


	public String getCode() {
		return code;
	}


	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString() {
		return String.format("%s.%s", code, description);
	}
	
	
	
}



