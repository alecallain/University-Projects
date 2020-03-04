package doubelyLinkedList;

import java.util.*;

public class DDLL {
	
	private Node head;
	private Node tail;
	private int size;
	
	public DDLL() {
		size = 0;
		head = null;
		tail = null;
	}
	
	public void addToEnd(Node n) {
		tail.setNextNode(n);
		n.setPrevNode(tail);
		// head = tail;
		tail = n;
		size++;
	}
	
	public Node removeFromEnd() {
		
		Node temp = tail;
		tail = tail.getPrevNode();
		tail.setNextNode(null);
		temp.setPrevNode(null);
		size--;
		
		return temp;
		
	}
	
	public boolean inList(Node n) {
		boolean containted = false;
		Node t = this.head;
		
		while(n != null) {
			if (t == n) {
				containted = true;
				break;
			}
			t = t.getNextNode();
		}
		
		return containted;
	}
	
	public static void main(String [] args) {
		
	}
	
}
