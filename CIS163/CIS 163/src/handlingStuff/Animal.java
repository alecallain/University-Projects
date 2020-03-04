package handlingStuff;

public class Animal {
	
	String[] names;
	
	public Animal() {
		names = new String[5];
	}
	
	public void addName(String name) throws ArrayFullException {
		
		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) {
				names[i] = name;
				return;
			}
		}
		
		throw new ArrayFullException(name);
	}
	
	public static void main(String [] args) {
		Animal dog = new Animal();
		try {
			dog.addName("dog");
			dog.addName("Roaver");
			dog.addName("Not a cat");
			dog.addName("Mutt");
			dog.addName("Pooch");
			dog.addName("Canine");
		} catch (ArrayFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
