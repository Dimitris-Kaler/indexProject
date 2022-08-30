package menu



import org.junit.jupiter.api.Test
import spock.lang.Specification

class MenuSpec extends Specification {

def "menu options"(){
	when:
	Menu menu=new Menu();
	
	then:
	menu.options()=="** WELCOME TO INDEX-PROJECT MENU\n"+
"***********************************\n"+
				"1:Insert Person\n"+
				"2.Delete Person\n"+
                "3.Print Index\n"+	
				"4.Print Specific List\n"+
                "5.Exit Program"

}
}
