package menu



import IndexProject.Index
import spock.lang.Specification

class PrintSpecificListMenuItemSpec extends Specification {
	
	def "initialise PrintSpecificMenuItemSpec"(){
		when:
		def mi=new PrintSpecificListMenuItem()
		
		then:
		mi.code=="4"
		mi.description=="Print Specific List"
		
	}
	

	
def "when execute method then FindSpecificLinkedList is called"(){
	//TODO THIS TESTING
	given:
	PrintSpecificListMenuItem mi=new PrintSpecificListMenuItem()
	
	Index indexMock=Mock()
	
	

	
	when:
	mi.execute(indexMock,new Scanner(System.in))
	
	then:
	1*indexMock.FindSpecificLinkedList()
	
	
	
}
	
	


}
