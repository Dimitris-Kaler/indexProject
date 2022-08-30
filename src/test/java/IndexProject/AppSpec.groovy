package IndexProject

import spock.lang.Specification

class AppSpec extends Specification {

	def "Hello World"(){
		given:
		App app=new App()
		
		when:
		def result=app.greeting()
		
		then:
		result=="Hello world"
		
	}
	
}
