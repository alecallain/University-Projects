import java.util.*;

public class BigO {

	public void functionThree(int n) {
		int max = n;
		for (int i = 0; i < n; i++){
			if (i== max) {
				max = 0;
			}
		}
		for (int j = 0; j < max; j++) {
			max = max + j;
		}
	}
	
	public void functionFour(int n) {
		int max = n;
		for (int i = 0; i < n; i/=2) {
			if (i == max) {
				max = 0;
				int temp = n;
			}
			for (int j = 0; j < n; j++) {
				max = n;
			}
		}
	}
	
	public static void main(String [] args) {
		BigO r = new BigO();
		
	}
	
}
