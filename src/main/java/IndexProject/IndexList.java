package IndexProject;

import java.util.LinkedList;


public class IndexList {
	private LinkedList<Person> list;
	private char listLetter;
	
	
	public IndexList(char listLetter) {
		this.list=new LinkedList<Person>();
		this.listLetter=listLetter;
	}
	
	public LinkedList<Person> getList() {
		return list;
	}


	public char getListLetter() {
		return listLetter;
	}

	
}
