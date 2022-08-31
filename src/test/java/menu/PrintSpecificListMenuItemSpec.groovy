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
	
	given:
	PrintSpecificListMenuItem mi=new PrintSpecificListMenuItem()
	
	Index index=new Index()
	
	
	
	and:
	def stub=index.FindSpecificLinkedList()
	
	stub==Stub()
	stub>>{"a"}
	
	when:
	mi.execute(indexStub,new Scanner(System.in))
	
	then:
	System.out.println("INDEX: A")
	
	
	
}
	
	


}
