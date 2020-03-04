import java.util.*;

/**
 * This is a class preparing me
 * for the 163 final
 * 
 * @author Alec Allain
 */
public class Review {
	
	
	/**
	 * constructor for class
	 */
	public Review() {
		
	}
	
	public void Queue() {
		int[] key = {5, 12, -3, 8, -9, 4, 10};
		Integer keyValue;
		String encoded = ""; 
		String decoded = "";
		String message = "All programmers love to code and " + "computers are the future. ";
		
		Queue<Integer> encodingQueue = new LinkedList<Integer>();
		Queue<Integer> decodingQueue = new LinkedList<Integer>();
		
		for (int i = 0; i < key.length; i++) {
			encodingQueue.add(key[i]);
			decodingQueue.add(key[i]);
		}
		
		//encodes message
		for (int i = 0; i < message.length(); i++) {
			keyValue = encodingQueue.remove();
			encoded += (char) (message.charAt(i) + keyValue);
			encodingQueue.add(keyValue);
		}
		
		System.out.println(encoded);
		
		//decodes message
		for (int i = 0; i < message.length(); i++) {
			keyValue = decodingQueue.remove();
			decoded += (char) (message.charAt(i) + keyValue);
			decodingQueue.add(keyValue);
		}
		
		System.out.println(decoded);
	}

	public static void main(String [] args) {
		Review r = new Review();
		r.Queue();
	}
	
}
