package menu



import IndexProject.Exit
import IndexProject.Index
import spock.lang.Specification

class ExitProgramMenuItemSpec extends Specification{
	ExitProgramMenuItem	mi
	def setup() {
	mi = new ExitProgramMenuItem()
	}


def "initialise ExitProgramMenuItem"(){
	expect:
	mi.code=="5"
	mi.description=="Exit The Program"
}

def "bye bye message"(){
	expect:
	mi.message()=="Bye Bye see you soon!!"
	
}
def"when execute method is called then a call to the method tha exits is made"(){
	given:
	Exit mock=Mock();
	mi.exit=mock;
	Scanner scanner = new Scanner(System.in)
	Index index=new Index()
	
	when:
	mi.execute(index,scanner)
	
	then:
	1* mock.doIt()
}

}
