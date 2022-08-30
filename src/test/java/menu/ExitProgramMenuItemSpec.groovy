package menu



import spock.lang.Specification

class ExitProgramMenuItemSpec extends Specification{

def "initialise ExitProgramMenuItem"(){
	when :
	def mi=new ExitProgramMenuItem()
	
	then:
	mi.code=="5"
	mi.description=="Exit The Program"
}

}
