package IndexProject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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


	public void add(Person person) {
		String fullName=person.getFullName();
		
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		String checkedFullName=fullName.trim();
		String firstLetter=String.valueOf(checkedFullName.charAt(0)).toLowerCase();
		
		
		
		int numberOfLinkedList=alphabet.indexOf(firstLetter);
		getPersonIndex().get(numberOfLinkedList).add(person);
		System.out.println("The Person has succesfully added!!");
	}
	
	public void delete(String name) {
	
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		String checkedFullName=name.trim();
		String firstLetter=String.valueOf(checkedFullName.charAt(0)).toLowerCase();
		int numberOfLinkedList=alphabet.indexOf(firstLetter);
		boolean nameExist=getPersonIndex().get(numberOfLinkedList).removeIf(person->person.getFullName().equals(name));
		if(nameExist==false) {
			System.out.println("This String doesnt exist");
		}else {
			System.out.println("String deleted!!");
		}
		
		
		
		
	}
	
	public void printSpecificList(char letter) {
		String alphabet="abcdefghijklmnopqrstuvwxyz";
		char character=Character.toUpperCase(letter);
		
	
		
		int numberOfLinkedList=alphabet.indexOf(letter);
		System.out.println("Full Name : Mobile Number");
		System.out.println("*************************");
		for(Person str:getPersonIndex().get(numberOfLinkedList)) {
			System.out.println(str.getFullName()+" "+str.getPhoneNumber());
			
		}
		System.out.println();
		
	}
	
	public void print() {
		String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0;i<getPersonIndex().size();i++) {
			System.out.println("INDEX: "+alphabet.charAt(i)+" ");
			System.out.println("Full Name : Mobile Number");
			System.out.println("*************************");
			
			for (int j=0;j<getPersonIndex().get(i).size();j++) {
				System.out.println(getPersonIndex().get(i).get(j).getFullName()+" : "+getPersonIndex().get(i).get(j).getPhoneNumber());
			}
			System.out.println();
		}
	}
	
	
	
	

}
