package menu;

import java.util.Scanner;

import IndexProject.Index;

public class PrintIndexMenuItem extends MenuItem {
	
	public PrintIndexMenuItem() {
		super("3","Print Index");
	}
	
    @Override
	public void execute(Index index,Scanner scanner) {
		for(int i=0;i<index.getPersonIndex().size();i++) {
			System.out.println("INDEX: "+index.getPersonIndex().get(i).getListLetter()+" ");
			System.out.println("Full Name : Mobile Number");
			System.out.println("*************************");
			for(int j=0;j<index.getPersonIndex().get(i).getList().size();j++) {
				
				System.out.println(index.getPersonIndex().get(i).getList().get(j).getFullName()+" : "+index.getPersonIndex().get(i).getList().get(j).getPhoneNumber());
			}
			System.out.println();
		}
	}

}
