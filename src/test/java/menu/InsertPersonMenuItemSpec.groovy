package menu

import IndexProject.Index
import IndexProject.IndexList
import IndexProject.Person
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
	
//	def "create a person to put it on the list"(){
//		given:
//
//		String name="Dimitris"
//		String phone="6795679456"
//
//		
//		
//		and:"A scanner that simulates the input"
//		Scanner scanner=new Scanner(simulateUserInput(name,phone))
//		
//		and:"and print stream for capturing program output"
//		OutputStream captureOutput=new ByteArrayOutputStream()
//		PrintStream out=new PrintStream(captureOutput)
//		
//		
//		when:
//		Person person=mi.createPersonToAdd(scanner,out)
//		
//		
//		then:
//		person.getFullName()=="Dimitris"
//		person.getPhoneNumber()=="6795679456"
//		
//	}
//	private def simulateUserInput(String name, String phone) {
//		new ByteArrayInputStream((name + System.lineSeparator() + phone).getBytes());
//	}
	
//	def "Save The Created Person To The Right List"(){
//		given:
//		Index mock=Mock()
//		
//		and:"A scanner that simulates the input"
//		Scanner scanner=new Scanner(simulateUserInput(name,phone))
//		
//		
//		when:
//		mi.execute(mock,scanner)
//	}

}
