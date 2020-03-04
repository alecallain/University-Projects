package doubelyLinkedList;

public class Node<T> {
	
	private T thisElement;
	private Node nextNode;
	private Node prevNode;
	
	public void setThisElement(T thisElement) {
		this.thisElement = thisElement;
	}
	
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}
	
	public T getThisElement() {
		return thisElement;
	}
	
	public Node getNextNode() {
		return nextNode;
	}
	
	public Node getPrevNode() {
		return prevNode;
	}
	
}
