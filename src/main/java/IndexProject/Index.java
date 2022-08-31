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
	
	
	
	

}
