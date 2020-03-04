package animals;

public abstract class Animal {

	public int numberOfLegs;
	public float topSpeed;
	public String name;
	
	public Animal(int numberOfLegs, float topSpeed, String name) {
		this.numberOfLegs = numberOfLegs;
		this.topSpeed = topSpeed;
		this.name = name;
	}
	
	public void eat() {
		System.out.println(name + " is eating.");
	}
	
	public abstract void move();
	
	public static void main(String [] args) {
		
	}
	
}
