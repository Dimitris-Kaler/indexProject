package menu



import spock.lang.Specification

class PrintSpecificListMenuItemSpec extends Specification {
	
	def "initialise PrintSpecificMenuItemSpec"(){
		when:
		def mi=new PrintSpecificListMenuItem()
		
		then:
		mi.code=="4"
		mi.description=="Print Specific List"
		
	}


}
