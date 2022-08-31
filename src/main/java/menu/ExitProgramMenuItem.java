package menu;

public class ExitProgramMenuItem extends MenuItem {
	public ExitProgramMenuItem() {
		super("5","Exit The Program");
	}
	@Override
	public void execute() {
		System.out.println("Bye Bye see you soon!!");
		System.exit(0);
	}
	


}
