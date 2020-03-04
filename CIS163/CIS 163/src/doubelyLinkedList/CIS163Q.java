package doubelyLinkedList;

import java.util.*;

/**
 * 
 */
public class CIS163Q<T> implements Queue<T> {
	
	private Node<T> first;
	private Node<T> last;
	private int size;
	private Queue<T> queue;
	
	/**
	 *
	 */
	public CIS163Q() {
		first = null;
		last = null;
		size = 0;
		queue = new LinkedList<T>();
	}
	
	/**
	 *
	 */
	public static void main(String [] args) {
		CIS163Q queue = new CIS163Q();
	}
}