package menu



import org.junit.jupiter.api.Test
import spock.lang.Specification

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
}
