package Inheritance;

/***********************
 * 
 * @author Ira Woodring
 **********************/

public class Mammals extends Animal{
	
	public Mammals(int lifeSpan, String name) {
		super();
	}
	
	public static void main(String [] args) {
		
		Mammals m1 = new Mammals(5, "mammal");
		System.out.println(m1.whatAmI()); 
	}
	
}
