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
	
	OutputStream captureOutput=new ByteArrayOutputStream()
	PrintStream out=new PrintStream(captureOutput)
	


	
	when:
	ui.validateChoice(scanner,out)
	
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
	
	OutputStream captureOutput=new ByteArrayOutputStream()
	PrintStream out=new PrintStream(captureOutput)
	
	when:
	ui.validateChoice(scanner,out)
	
	then:
	notThrown(InvalidMenuChoice)
	
	where:
	choice<<("1".."5")
}

def prompt() {
	given:
	OutputStream captureOutput=new ByteArrayOutputStream()
	PrintStream out=new PrintStream(captureOutput)
	
	when:
	ui.prompt(out)
	
	
	then:
	captureOutput.toString()=="Enter choice: ${System.lineSeparator()}"
}

def printMenuOptions() {
		given:
		Menu menu = Stub()
		String options = "option1${System.lineSeparator()}option2"
		menu.options() >> options
		ui = new UI(menu)

		OutputStream captureOutput = new ByteArrayOutputStream()
		PrintStream out = new PrintStream(captureOutput)

		when:
		ui.printMenuOptions(out)

		then:
		captureOutput.toString() == options + System.lineSeparator()

	}
	
	def"parse input with valid choice"(){
		given:
		def userKeys="1"+System.lineSeparator()
		ByteArrayInputStream input = new ByteArrayInputStream(userKeys.getBytes())
		Scanner scanner = new Scanner(input)

		CLIMenuChoiceValidator stub = Stub()
		ui.cliMenuChoiceValidator = stub

		OutputStream captureOutput = new ByteArrayOutputStream()
		PrintStream out = new PrintStream(captureOutput)

		when:
		String choice = ui.parseInputFromCommandLine(scanner, out)

		then:
		choice == "1"
		captureOutput.toString() == "Enter choice: ${System.lineSeparator()}Choice:1${System.lineSeparator()}Enter choice: ${System.lineSeparator()}"
	}
	
	def "parse invalid input"() {
		given:
		def userKeys = "a" + System.lineSeparator()
		ByteArrayInputStream input = new ByteArrayInputStream(userKeys.getBytes())
		Scanner scanner = new Scanner(input)

		CLIMenuChoiceValidator stub = Stub()
		stub.validate(_) >> {throw new RuntimeException("fail")}
		ui.cliMenuChoiceValidator = stub

		OutputStream captureOutput = new ByteArrayOutputStream()
		PrintStream out = new PrintStream(captureOutput)

		when:
		String choice = ui.parseInputFromCommandLine(scanner, out)

		then:
		choice == null
		notThrown(Exception)

		captureOutput.toString() == "Enter choice: ${System.lineSeparator()}Choice:a${System.lineSeparator()}Enter choice: ${System.lineSeparator()}"
		//TODO capture system error
	}
	

}
