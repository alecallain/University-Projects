package Inheritance;

/***********************
 * 
 * @author Ira Woodring
 **********************/

public class Animal {
	
	int lifeSpan;
	String name;
	
	public void eat() {
		
	}
	
	public String whatAmI() {
		return "I am a " + name + " and I live for " + lifeSpan + " years.";
	}

}
