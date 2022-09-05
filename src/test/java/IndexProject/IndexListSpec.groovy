package IndexProject



import spock.lang.Specification
import exceptions.EmptyLetterIndexListNotAllowedException

class IndexListSpec extends Specification {
	
	def "initialize indexList"(){
		when:
		IndexList IndexList=new IndexList(listLetter.charAt(0));
		
		
		then:
		IndexList.list==new LinkedList<Person>()
		IndexList.listLetter==listLetter
		
		where:
        listLetter<<( 'A'..'Z')
	}
	
	
	def "create indexList with empty value for listLetter"(){
		when:
		IndexList indexList=new IndexList("")
		
		then:
		def e=thrown(EmptyLetterIndexListNotAllowedException.class)
		e.message=="Expected char for indexlist letter but got empty String instead."
	}
	
	

}
