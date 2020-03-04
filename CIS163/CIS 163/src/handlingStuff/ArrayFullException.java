package handlingStuff;

public class ArrayFullException extends Exception {
	
	public ArrayFullException(String message) {
		super("This array is full! Can't add " + message);
	}
	
	public static void main(String [] args) {
		
	}

}
