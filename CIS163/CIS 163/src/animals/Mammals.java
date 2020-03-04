package animals;

public class Mammals extends Animal {
	
	private int poundsOfHair;

	public Mammals(int numberOfLegs, float topSpeed, String name) {
		super(numberOfLegs, topSpeed, name);
		poundsOfHair = 0;
		// TODO Auto-generated constructor stub
	}
	
	public Mammals(int numberOfLegs, float topSpeed, String name, int poundsOfHair) {
		super(numberOfLegs, topSpeed, name);
		this.poundsOfHair = poundsOfHair;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("This mammal is running.");
	}
	
	public static void main( String [] args) {
		
		Mammals m = new Mammals(4, (float) 38.00, "Big  Burly Bear");
		m.move();
		m.eat();
		
	}

}
