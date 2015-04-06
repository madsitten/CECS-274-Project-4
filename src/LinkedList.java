/**
 * Recursive Linked List of String nodes
 * @author Julian Poyourow
 *
 */
public class LinkedList {
	/**
	 * Keep track of first node
	 */
	private Node first;
	/**
	 * Initiate the list with first node set to null (empty)
	 */
	public LinkedList() {
		first = null;
	}
	/**
	 * Check if LinkedList is empty
	 * @return Linked list is empty
	 */
	public boolean isEmpty() {
		return first == null;
	}
	/**
	 * Get the size of the LinkedList
	 * @return Size of LinkedList
	 */
	public int size() {
		return size(first);
	}
	/**
	 * Recursively calculate the size of the LinkedList
	 * @param list Starting node
	 * @return Total size of LinkedList
	 */
	private int size( Node list ) {
		if( list == null ) {
			return 0;
		} else {
			return size( list.getNext() ) + 1;
		}
	}
	/**
	 * Fetch a node from the LinkedList
	 * @param i Index to fetch
	 * @return The node at the index specified
	 */
	public Node get( int i ) {
		return get( i, 0, first );
	}
	/**
	 * Recursively access a node in the LinkedList
	 * @param i Index of the node
	 * @param count Counter for iteration
	 * @param list Starting node in list
	 * @return Node at the index specified
	 */
	private Node get( int i, int count, Node list ) {
		if( list == null ){
			return null;
		}else if( count == i ){
			return list;
		}else{
			return get( i, count+1, list.getNext() );
		}
	}
	/**
	 * Add a string to the LinkedList
	 * @param s String to be added
	 */
	public void add( Song s ){
		first = add( s, first );
	}
	/**
	 * Add a string to the LinkedList
	 * @param s String to be added
	 * @param i Index of string to be added
	 */
	public void add( Song s, int i ){
		add( s, first, i, 0 );
	}
	/**
	 * Recursively add a string to the LinkedList
	 * @param s String to be added
	 * @param list Starting node in the LinkedList
	 * @return New node that was added
	 */
	private Node add( Song s, Node list ){
		if( list == null ){
			return new Node(s);
		}else{
			list.setNext( add( s, list.getNext() ) );
			return list;
		}
	}
	/**
	 * Recursively add a string to the LinkedList
	 * @param s String to be added
	 * @param list Starting node in the LinkedList
	 * @param i Index of string to be added
	 * @param count Iterative counter
	 * @return New node that was added
	 */
	private Node add( Song s, Node list, int i, int count ){
		if( list == null ){
			System.out.println("Could not add node " + s);
			return null;
		}else if( i == 0 ){
			Node next = list;
			list = new Node(s);
			list.setNext(next);
			first = list;
			return list;
		}else if( count + 1 == i ){
			Node n = new Node(s);
			Node next = list.getNext();
			list.setNext( n );
			list.getNext().setNext( next );
			return list;
		}else{
			list.setNext( add( s, list.getNext(), i, count+1 ) );
			return list;
		}
	}
	/**
	 * Remove a node from the LinkedList
	 * @param i Index of the node to remove
	 * @return Node that was removed
	 */
	public Node remove( int i ){
		return remove( i, 0, first );
	}
	/**
	 * Remove a node from the LinkedList
	 * @param s String value of node to remove
	 * @return Node that was removed
	 */
	public Node remove( Song s ){
		return remove( s, first );
	}
	/**
	 * Remove a node from the LinkedList
	 * @param s String value of a node to remove
	 * @return Node that was removed
	 */
	public Node remove( Song s, Node list ){
		if(list.getNext() != null){
			if(list.getNext().getValue() == s){
				Node n = list.getNext();
				list.setNext( list.getNext().getNext() );
				return n;
			} else {
				return remove(s, list.getNext());
			}
		}
		return null;
	}
	/**
	 * Recursively remove a node from the LinkedList
	 * @param i Index of the node to remove
	 * @param count Iterative counter
	 * @param list Starting node in the LinkedList
	 * @return Node that was removed
	 */
	private Node remove( int i, int count, Node list ){
		if( list == null ){
			return null;
		}else if( i == 0 ){
			first = list.getNext();
			return list;
		}else if( count + 1 == i ){
			Node n = list.getNext();
			if( list.getNext() != null ){
				list.setNext( list.getNext().getNext() ); }
			return n;
		} else{
			return remove( i, count+1, list.getNext() ); }
	}
	
	/**
	 * Converts the LinkedList to a pretty string
	 * @return Pretty string of the LinkedList
	 */
	@Override
	public String toString(){
		return createString(first, "");
	}
	
	/**
	 * Builds the string for the toString function
	 * @param list Node in the LinkedList
	 * @param build String to build onto
	 * @return Built string
	 */
	private String createString(Node list, String build){
		if(list != null){
			build = build + list.getValue() + " ";
			return createString(list.getNext(), build);
		}
		return build;
	}

}
