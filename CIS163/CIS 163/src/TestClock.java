
public class Go {
	
	Clock cl;
	
	public Go() {
		cl = new Clock(10000);
		Person joe = new Person();
		Person steph = new Person();
		Dog molly = new Dog();
		cl.add(joe);
		cl.add(steph);
	}

	public static void main(String [] args) {
		
	}
	
}
