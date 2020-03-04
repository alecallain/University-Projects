package stackProblems;

import java.util.*;

public class PostFix {
	
	Stack<Integer> stack = new Stack<Integer>();
	private String postfix;
	
	public PostFix(String postfix) {
		this.postfix = postfix;
		
	}
	
	public Integer solve() {
		String[] tokens = this.postfix.split(" ");
		for (String token : tokens) {
			try {
				Integer i = Integer.parseInt(token);
				stack.push(i);
				System.out.println("Putting " + i + " on the stack");
			}
			catch (NumberFormatException e) {
				Integer first = stack.pop();
				Integer second = stack.pop();
				Integer result = 0;
				System.out.println("Evaluating " + second + " ");
				switch(token) {
				case "+":
					result = second - first;
					break;
				case "-":
					result = second - first;
					break;
				case "*":
					result = second * first;
					break;
				case "/":
					result = second / first;
					break;
				}
				System.out.println(first + " = " + result);
				stack.push(result);
			}
		}
		return stack.pop();
		
	}
	
	public Integer spareSolve() {
		
		for (int i = 0; i< this.postfix.length(); i++) {
			if (Character.isDigit(postfix.charAt(i))) {
				stack.push(Integer.parseInt("" + postfix.charAt(i)));
			}
		}
		
		return stack.pop();
	}
	
	public static void main(String [] args) {
		PostFix p = new PostFix("4 5 + 7 2 - * *");
		System.out.println(p.solve());
	}
	
}
