package IndexProject

import spock.lang.Specification

class IndexSpec extends Specification {

	def "initialise index"(){
		when:
		Index index=new Index()
		
		then:
		index.personIndex==new ArrayList<LinkedList<Person>>(26)
			
	}

}
