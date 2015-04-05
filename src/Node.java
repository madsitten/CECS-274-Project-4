/**
 * Node of an LinkedList of Circles
 * @author Julian Poyourow
 *
 */
public class Node {
	/** Value of the Node, holding a Circle object */
	private Song value;
	/** Next item in the LinkedList of Circle Nodes */
	private Node next;
	/**
	 * Creates a node for a circle
	 * @param v Value of node (circle)
	 */
	public Node( Song v ) {
		value = v;
		next = null;
	}
	/**
	 * Creates a node for a circle with a next node specified
	 * @param v Value of node (circle)
	 * @param n Next node
	 */
	public Node( Song v, Node n ) {
		value = v;
		next = n;
	}
	/**
	 * Gets the next node
	 * @return Next node in LinkedList
	 */
	public Node getNext() {
		return next;
	}
	/**
	 * Sets the next node
	 * @param n Next node in LinkedList
	 */
	public void setNext( Node n ) {
		next = n;
	}
	/**
	 * Gets the value of the node
	 * @return Circle as part of node
	 */
	public Song getValue() {
		return value;
	}
	/**
	 * Sets the value of the node
	 * @param v Circle as the value of node
	 */
	public void setValue( Song v ) {
		value = v;
	}
}
