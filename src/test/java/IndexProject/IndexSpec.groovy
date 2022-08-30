package IndexProject

import spock.lang.Specification

class IndexSpec extends Specification {

	def "initialise index"(){
		when:
		Index index=new Index()
		
		then:
		def e=index.personIndex
		e==new ArrayList<LinkedList<Person>>()
			
	}

}
