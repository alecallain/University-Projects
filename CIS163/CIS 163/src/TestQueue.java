import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class TestQueue {

	public static boolean isPalindrome(String word) {
		boolean palindrome = true;
		
		Stack<String> s = new Stack<String>();
		Queue<String> q = new LinkedList<String>();
		
		for (int i = 0; i < word.length(); i++) {
			s.add(" " + word.charAt(i));
			q.add(" " + word.charAt(i));
		}
		
		if (s.size() != q.size()) {
			palindrome = false;
		}
		
		for (int i = 0; i < word.length(); i++) {
			if (!s.pop().equals(q.remove())) {
				palindrome = false;
			}
			else {
				palindrome = true;
			}
		}
		
		return palindrome;
	}
	
	
	public static void main(String [] args) {
		String p1 = "racecar";
		System.out.println("racecar?    " + isPalindrome(p1));
		System.out.println("poop?    " + isPalindrome("poop"));
		System.out.println("1001001001?    " + isPalindrome("1001001001"));
	}
	
}
