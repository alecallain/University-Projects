
public class Fac {

	public int fac(int n) {
		if (n==1) {
			return 1;
		}
		
		return n * fac(n-1);
	}
	
	public int fib(int n) {
		if (n <= 1) {
			return 1;
		}
		return fib(n-2) + fib(n-1);
	}
	
	public static void main(String [] args) {
		Fac f = new Fac();
		//System.out.println("" + f.fac(10));
		System.out.println("" + f.fib(10));
	}
	
}
