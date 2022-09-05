package IndexProject;

import java.util.LinkedList;

import exceptions.EmptyLetterIndexListNotAllowedException;
import exceptions.EmptyNameNotAllowedException;


public class IndexList {
	private LinkedList<Person> list;
	private char listLetter;
	
	
	public IndexList(char listLetter) {
		this.list=new LinkedList<Person>();
		this.listLetter=listLetter;
		//TODO VALIDATION
		validateIndexList();
	}
	
	public LinkedList<Person> getList() {
		return list;
	}


	public char getListLetter() {
		return listLetter;
	}
	
	private void validateIndexList() {
		validateLetterEmptyValue();
	}
	
    private void validateLetterEmptyValue() {
    	if("".equals(listLetter)){
    		throw new EmptyLetterIndexListNotAllowedException();
    	}
		
	}
	
	 

	
}
