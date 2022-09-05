package IndexProject

import static org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import spock.lang.Specification

class PersonCLIParserSpec extends Specification {
	PersonCLIParser mi;
	
	def setup() {
		mi=new PersonCLIParser();
	}

	def "create a person to put it on the list"(){
		given:

		String name="Dimitris"
		String phone="6795679456"

		
		
		and:"A scanner that simulates the input"
		Scanner scanner=new Scanner(simulateUserInput(name,phone))
		
		and:"and print stream for capturing program output"
		OutputStream captureOutput=new ByteArrayOutputStream()
		PrintStream out=new PrintStream(captureOutput)
		
		
		when:
		Person person=mi.parsePerson(scanner,out)
		
		
		then:
		person.getFullName()=="Dimitris"
		person.getPhoneNumber()=="6795679456"
		
	}
	private def simulateUserInput(String name, String phone) {
		new ByteArrayInputStream((name + System.lineSeparator() + phone).getBytes());
	}
}
