package IndexProject

import menu.Menu
import spock.lang.Specification
import spock.lang.Unroll
import exceptions.InvalidMenuChoice

class UISpec extends Specification {
	UI ui;
	def setup() {
		ui=new UI();
	}


@Unroll
def "accept input throws exception if not between 1 and 5"(){
	given:
	def input=new ByteArrayInputStream((choice+System.lineSeparator()).getBytes())
	Scanner scanner=new Scanner(input)
	given:

	
	when:
	ui.validateChoice(scanner)
	
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
	ui.validateChoice(scanner)
	
	then:
	notThrown(InvalidMenuChoice)
	
	where:
	choice<<("1".."5")
}

def prompt() {
	OutputStream captureOutput=new ByteArrayOutputStream()
	PrintStream out=new PrintStream(captureOutput)
	
	when:
	ui.prompt(out)
	
	
	then:
	captureOutput.toString()=="Enter choice: ${System.lineSeparator()}"
}
	

}
