package menu



import spock.lang.Specification

class PrintIndexMenuItemSpec extends Specification{

	def "initialse PrintIndexMenuItem"(){
		when:
		def mi=new PrintIndexMenuItem()
		
		then:
		mi.code=="3"
		mi.description=="Print Index"
	}


}
