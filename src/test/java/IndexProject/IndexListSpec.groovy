package IndexProject



import spock.lang.Specification

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
	
	

}
