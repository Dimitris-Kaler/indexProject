package menu


import spock.lang.Specification

class MenuItemSpec extends Specification {

	
	def "initialze menuItem with code and desscription"(){
		
		when:
		def mi=new MenuItem("1","description")
		
		then:
		mi.code == "1"
		mi.description == "description"
	}
}
