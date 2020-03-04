package exceptionTutorial;
import java.util.*;

public class DemonstrateException {
	
	Scanner scnr = new Scanner(System.in);

	public DemonstrateException() throws NegativeNumberException {
		System.out.println("Give me some value: ");
		int x = scnr.nextInt();
		if (x < 0) {
			throw new NegativeNumberException("You cant have a negative number");
		}
		
	}
	
	public static void main (String [] args) throws NegativeNumberException {
		try {
			DemonstrateException d = new DemonstrateException();
		}
		finally {
			
		}
	}
	
}
