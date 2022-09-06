package IndexProject

import spock.lang.Specification
import exceptions.InvalidMenuChoice
import spock.lang.Unroll

class AppSpec extends Specification {

@Unroll
def "accept input throws exception if not between 1 and 5"(){
	given:
	def input=new ByteArrayInputStream((choice+System.lineSeparator()).getBytes())
	Scanner scanner=new Scanner(input)
	given:

	
	when:
	App.validateChoice(scanner)
	
	then:
	def e=thrown(InvalidMenuChoice)
	e.message == "Expected value between 1 and 5 but got ${choice} instead."
	
	where:
	choice<<["a","asdfaghacdws","112","0",null]
}

@Unroll
def "accept input only between 1 and 5"(){
	given:
	def input = new ByteArrayInputStream((choice + System.lineSeparator() ).getBytes());
	Scanner scanner = new Scanner(input)
	
	when:
	App.validateChoice(scanner)
	
	then:
	notThrown(InvalidMenuChoice)
	
	where:
	choice<<("1".."5")
}

def prompt() {
	OutputStream captureOutput=new ByteArrayOutputStream()
	PrintStream out=new PrintStream(captureOutput)
	
	when:
	App.prompt(out)
	
	
	then:
	captureOutput.toString()=="Enter choice: ${System.lineSeparator()}"
}
	
}
