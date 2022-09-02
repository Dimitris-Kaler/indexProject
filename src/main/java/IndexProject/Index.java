package IndexProject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Index {
	final static String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private List<IndexList> personIndex;
	
	
	public Index() {
		personIndex=new ArrayList<IndexList>(26);
		
		for (int i=0;i<26;i++) {
			
			personIndex.add(new IndexList(alphabet.charAt(i)));
		}
	}


	public List<IndexList> getPersonIndex() {
		return personIndex;
	}
	

	
	public IndexList FindSpecificIndexList(String str) {
		String checkedFullName=str.trim().toUpperCase();
		char firstLetter=checkedFullName.charAt(0);
		for(IndexList indexli:getPersonIndex()) {
			if(indexli.getListLetter()!=firstLetter) {
				continue;
			}else {
			return indexli;
		}
	}
		return null;
	
 }
}
