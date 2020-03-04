package animals;

public class Bird extends Animal implements Flyers, Singers {

	public Bird(int numberOfLegs, float topSpeed, String name) {
		super(numberOfLegs, topSpeed, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("This bird is on the move");
	}
	
	public static void main (String [] args) {
		Bird b = new Bird(2, (float) 12.7, "Robin");
		b.move();
		b.fly();
		b.sing();
		b.eat();
		b.glide();
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("This bird is singing.");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("This bird is flying");
	}

	@Override
	public void glide() {
		// TODO Auto-generated method stub
		System.out.println("This bird is gliding");
	}

	@Override
	public void dive() {
		// TODO Auto-generated method stub
		System.out.println("This bird is diving");
	}

}
