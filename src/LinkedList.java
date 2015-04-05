/**
 * A linked list containing Nodes
 * @author Julian Poyourow
 *
 */
public class LinkedList {
	/** Holds the first member of the LinkedList */
	private Node first;
	/** Holds the last member of the LinkedList */
	private Node last;
	/**
	 * Creates a new empty LinkedList
	 */
	public LinkedList() {
		first = null;
		last = null;
	}
	/**
	 * Checks if the LinkedList is empty
	 * @return LinkedList is empty based on first item
	 */
	public boolean isEmpty(){
		return first == null;
	}
	/**
	 * Gets the size of the LinkedList
	 * @return Size of LinkedList
	 */
	public int size() {
		int count = 0;
		Node p = first;
		while( p != null ) {
			count++;
			p = p.getNext();
		}
		return count;
	}
	/**
	 * Gets a particular node as part of the LinkedList
	 * @param i Index of the node
	 * @return  Node requested
	 */
	public Node get( int i ) {
		Node prev = first;
		for(int j=1; j<=i; j++) {
			prev = prev.getNext();
		}
		return prev;
	}
	/**
	 * Returns LinkedList as pretty string
	 * @return Pretty string of LinkedList
	 */
	public String toString() {
		String str = "";
		Node n = first;
		while( n != null ) {
			str = str + n.getValue();
			n = n.getNext();
		}
		return str;
	}
	/**
	 * Adds a circle to the LinkedList
	 * @param s Circle to be added
	 */
	public void add(Song s){
		if(isEmpty()){
			first = new Node(s);
			last = first;
		} else {
			Node n = new Node(s);
			last.setNext(n);
			last = n;
		}
	}
}
