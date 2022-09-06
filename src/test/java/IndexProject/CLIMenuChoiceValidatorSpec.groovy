package IndexProject


import spock.lang.Unroll
import spock.lang.Specification
import exceptions.InvalidMenuChoice

class CLIMenuChoiceValidatorSpec extends Specification {
	
	
@Unroll
def "validate throws exception if choice not between 1 and 6"(){
	given:
	CLIMenuChoiceValidator val=new CLIMenuChoiceValidator()
	
	when:
	val.validate(choice)
	
	then:
	def e=thrown(InvalidMenuChoice)
	e.message=="Expected value between 1 and 5 but got ${choice} instead."
	
	where:
	choice << ["a", "asdfasdgfasdg", "112", "0", null]
}

@Unroll
def"accept input only between 1 and 5"(){
	given:
	CLIMenuChoiceValidator val=new CLIMenuChoiceValidator()
	
	when:
	val.validate(choice)
	
	then:
	notThrown(InvalidMenuChoice)
	
	where:
	choice<<("1".."5")
}

}
