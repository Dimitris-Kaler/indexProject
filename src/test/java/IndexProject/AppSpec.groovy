package IndexProject

import spock.lang.Specification
import exceptions.InvalidMenuChoice
import spock.lang.Unroll

class AppSpec extends Specification {

@Unroll
def "accept input throws exception if not between 1 and 5"(){
	when:
	App.acceptChoice(choice)
	
	then:
	def e=thrown(InvalidMenuChoice)
	e.message == "Expected value between 1 and 5 but got ${choice} instead."
	
	where:
	choice<<["a","asdfaghaksjcdws","112","0",null]
}

@Unroll
def "accept input only between 1 and 5"(){
	when:
	App.acceptChoice(choice)
	then:
	notThrown(InvalidMenuChoice)
	
	where:
	choice<<("1".."5")
}
	
}
