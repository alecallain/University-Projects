package exceptionTutorial;

public class UncaughtExceptionDemo {

	public UncaughtExceptionDemo() {
		
		int a = 42;
		int b = 0;
		int c = 1000;
		try {
			System.out.print(a/b);
		}
		catch (ArithmeticException ex) {
			System.out.println("Can't divide by zero");
		}
		catch (Exception ex) {
			//ex.printStackTrace();
			System.out.println("Your an idiot");
		}
		finally {
			System.out.println(c);
			System.out.println("Yay we did it");
		}
	}
	
	public static void main(String [] args) {
		UncaughtExceptionDemo d = new UncaughtExceptionDemo();
	}
	
}
