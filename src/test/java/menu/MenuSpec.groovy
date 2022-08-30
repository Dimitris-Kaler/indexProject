package menu


import exceptions.InvalidMenuItemCode
import org.junit.jupiter.api.Test
import spock.lang.Specification
import spock.lang.Unroll

class MenuSpec extends Specification {


def "menu options"(){
	given:
	Menu menu=new Menu();
	
	expect: 
	menu.options()=="""WELCOME TO INDEX-PROJECT MENU
***********************************
1.Insert Person
2.Delete Person
3.Print Index
4.Print Specific List
5.Exit The Program"""	
}

def "searching for menu item with invalid code"(){
	given:
	Menu menu=new Menu()
	
	when:
	MenuItem mi=menu.findByCode("1w3")
	
	then:
	thrown(InvalidMenuItemCode)
}

def "searching for menu item with null"(){
	given:
	Menu menu=new Menu();
	
	when:
	MenuItem mi=menu.findByCode(null)
	
	
	then:
	thrown(InvalidMenuItemCode)
}


@Unroll
def "find menu by code"(){
	given:
	Menu menu=new Menu()
	
	when:
	MenuItem mi=menu.findByCode(code)
	
	then:
	mi.code==code
	mi.description==description
	
	where:
	code|description
	"1" |"Insert Person"
	"2" |"Delete Person"
	"3" |"Print Index"
	"4" |"Print Specific List"
	"5" |"Exit The Program"
}


	
}
