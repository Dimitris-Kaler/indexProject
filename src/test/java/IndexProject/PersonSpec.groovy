package IndexProject

import spock.lang.Specification
import spock.lang.Unroll
import exceptions.NullNameNotAllowedException
import exceptions.EmptyNameNotAllowedException
import exceptions.DigitsInTheNameNotAllowedException
import exceptions.EmptyPhoneNumberNotAllowedException
import exceptions.NullPhoneNumberNotAllowedException
import exceptions.PhoneNumberNotMatchedException

class PersonSpec extends Specification {

	
	@Unroll
	def"initialise Person"(){
	when:
	Person person=new Person(fullName,phoneNumber)
	
	then:
	person.fullName==fullName
	person.phoneNumber==phoneNumber
	
	where:
	fullName  | phoneNumber
	"dimitris"| "6974357349"
	"lefteris"| "6934561290"
	
	
}

def "create person with null name"(){
	when:
	Person person=new Person(null,"6978910321")
	
	
	then:
	def e=thrown(NullNameNotAllowedException.class)
	e.message=="Expected name for person but got null name instead."
	
}

def "create person with empty name"(){
	when:
	new Person("","6984567891")
	
	then:
	def e=thrown (EmptyNameNotAllowedException.class)
	e.message=="Expected name for person but got empty value instead."
	
	
	
}

def "create person with numbers in his name"(){
	when:
	new Person("45Dimitr9s","6987234512")
	
	
	then:
	def e=thrown(DigitsInTheNameNotAllowedException.class)
	e.message=="Expect name for person without digits but got with digits instead."
}

def "create person with null phoneNumber"(){
	when:
	new Person("Dimitris",null)
	
	then:
	def e=thrown(NullPhoneNumberNotAllowedException.class)
}

def "create person with empty phoneNumber"(){
	when:
	new Person("Dimitris","")
	
	then:
	def e=thrown(EmptyPhoneNumberNotAllowedException.class)
	e.message=="Expect phoneNumber for person but got emty value instead."
}

@Unroll
def "create person with phoneNumber which doesnt matches with regex"(){
	when:
	def person=new Person("Dimitris",phoneNumber);
	
	then:
	def e=thrown(PhoneNumberNotMatchedException.class)
	e.message=="Expect phoneNumber to match to pattern but got false instead."
	
	where:
	phoneNumber<<["2134554647568568","69werrtt.23","5699991234"]
	
	
	
	
}

	
	

}
