package menu

import IndexProject.Index
import IndexProject.IndexList
import IndexProject.Person
import IndexProject.PersonCLIParser
import spock.lang.Specification

class InsertPersonMenuItemSpec extends Specification {

	InsertPersonMenuItem mi
	def setup() {
		mi=new InsertPersonMenuItem()
	}
	
	def "initialise InserPersonMenuItemSpec"(){
		expect:
		mi.code=="1"
		mi.description=="Insert Person"
	}
	
	def execute() {
		given:"index"
		Index index=Mock()
		IndexList inList=new IndexList('d'.charAt(0))
		
		and: "a parser that returns an Person successfully"
		PersonCLIParser mock = Mock()
		Person person =new Person("dimitris","6995633425")
		mi = new InsertPersonMenuItem(mock);
		
		and: "a simulated user input"
		def input = new ByteArrayInputStream((System.lineSeparator()).getBytes());
		Scanner scanner = new Scanner(input)
		
		and:
		PrintStream out=Mock();
		
		when:
		mi.execute(index, scanner, out)
		
		then:"the parser is called with approriate input"
		1*mock.parsePerson(scanner, out)>>person
		1*index.FindSpecificIndexList(person.getFullName())>>inList
		1*out.println('The Person has succesfully added!!')
		
		and:"The parsed Person lives inside the right indexList"
		inList.getListLetter()=='d'
		inList.getList().size()==1
		inList.getList().first()==person
			
		
	}
	


}
