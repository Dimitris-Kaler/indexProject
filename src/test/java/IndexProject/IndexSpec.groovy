package IndexProject

import spock.lang.Specification
import spock.lang.Unroll

class IndexSpec extends Specification {
	
	@Unroll
	def "initialize index"(){
	when:
	Index index=new Index()
	
	then:
	index.getPersonIndex().get(i) == new LinkedList<Person>()
	
	where:
	i<<(0..25)
		
		
		
		
		
		
	}

}
