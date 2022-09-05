package menu



import IndexProject.Index
import IndexProject.IndexList
import IndexProject.Person
import spock.lang.Specification

class PrintSpecificListMenuItemSpec extends Specification {
	
	def "initialise PrintSpecificMenuItemSpec"(){
		when:
		def mi=new PrintSpecificListMenuItem()
		
		then:
		mi.code=="4"
		mi.description=="Print Specific List"
		
	}
	
//	def "call FindLetterOfTheLinkedList() and dont give char"(){
//		when:
//		def mi=new PrintSpecificListMenuItem();
//		Scanner scanner=Stub();
//		scanner.nextInt()>>3
//		mi.FindLetterOfTheLinkedList(scanner)
//		
//		
//		then:
//		def e=thrown(NullNameNotAllowedException.class)
//		e.message=="Expected name for person but got null name instead."
//		
//		
//		
//	}
	def "listHeader"(){
		when:
		PrintSpecificListMenuItem mi=new PrintSpecificListMenuItem();
		def letter="A"
		
		then:
		mi.listHeader(letter)=="INDEX: A\nFull Name : Mobile Number\n*************************"
		
	}
	
	def "when indexlist is empty and we call listBody"(){
		given:
		PrintSpecificListMenuItem mi=new PrintSpecificListMenuItem();
		IndexList inList=new IndexList("A".charAt(0));
		def list=inList.getList()
		
		when:
		list.isEmpty();
		
		
		then:
		mi.listBody(list)=="-"
	}
	
	
	def"when indexList has person and we call listBody"(){
		when:
		PrintSpecificListMenuItem mi=new PrintSpecificListMenuItem();
		IndexList inList=new IndexList("A".charAt(0));
		def list=inList.getList()
		
		and:"Person inside the list"
		Person personMock=Stub()
		personMock.fullName>>"alekos"
		personMock.phoneNumber>>"6984579867"
		list.add(personMock) 
		
		then:
		mi.listBody(list)=="alekos : 6984579867\n"
		
		
	}
	

	
def "when execute method then FindSpecificLinkedList is called"(){
	//TODO THIS TESTING
	given:
	def mi=newPrintSpecificListMenuItem();
	
	Index indexMock=Mock(Index)
	Scanner scanner=new Scanner(System.in)
	def letter=mi.FindLetterOfTheLinkedList(scanner)
	def list=indexMock.FindSpecificIndexList(letter)

	
	

	
	when:
	mi.execute(indexMock,scanner)
	
	then:
	mi.printList(letter, list)
	
	
	
}
	
	


}
