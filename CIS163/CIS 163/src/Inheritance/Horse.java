package Inheritance;

public class Horse extends Mammals {

	public Horse(int lifeSpan, String name) {
		super(lifeSpan, name);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String [] args) {
		Horse m1 = new Horse(5, "Horse");
		System.out.println(m1.whatAmI());
	}

}
