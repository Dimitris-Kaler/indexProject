package menu


import spock.lang.Specification

class MenuItemSpec extends Specification {

	def "it has code"(){
		expect:
		new MenuItem("1")
	}
}
