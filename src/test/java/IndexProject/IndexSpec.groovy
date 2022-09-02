package IndexProject

import spock.lang.Specification
import spock.lang.Unroll

class IndexSpec extends Specification {
	@Unroll
	def "initialise index"(){
		given:
		Index index=new Index()

		when:
		index.getPersonIndex().get(integer)
		
		then:
		new IndexList(index.alphabet.charAt(integer))
		
		where:
	    integer<<(0..25)
		

	}
	
	
	
	def'find specific indexList'(){
		given:
		Index index=new Index()
		IndexList mockList=Mock()
		
		
		when:
		mockList=index.FindSpecificIndexList('dimitris');
		
		
		then:
		mockList.getListLetter()=='D';
		
		
	}

}
