package IndexProject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Index {
	
	private List<LinkedList<Person>> personIndex;
	
	
	public Index() {
		personIndex=new ArrayList<LinkedList<Person>>(26);
		
		for (int i=0;i<26;i++) {
			personIndex.add(new LinkedList<Person>());
		}
	}


	public List<LinkedList<Person>> getPersonIndex() {
		return personIndex;
	}
	
	public void setPersonIndex(List<LinkedList<Person>> personIndex) {
		this.personIndex=personIndex;
		
	}
	
	public LinkedList<Person>FindSpecificLinkedList(String str) {
		final String alphabet="abcdefghijklmnopqrstuvwxyz";
		String checkedFullName=str.trim();
		String firstLetter=String.valueOf(checkedFullName.charAt(0)).toLowerCase();
		int numberOfLinkedList=alphabet.indexOf(firstLetter);
		return getPersonIndex().get(numberOfLinkedList);	
		
	}
	
	
	
	

}
