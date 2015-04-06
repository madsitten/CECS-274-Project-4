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
	public void add( Song s, int i ) {
		if( i < 0 || i > size() ) {
			System.out.println("Index out of bounds.");
		} else {
			if( i == 0 ){
				first = new Node( s, first );
			} else {
				Node prev = get( i - 1 );
				prev.setNext( new Node( s, prev.getNext() ) );
			}
		}
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
	
	public Node remove( int i ) {
		Node n = null;
		if( i < 0 || i >= size() ) {
			System.out.println("Index out of bounds.");
		} else {
			if( i == 0 ) {
				n = first;
				first = first.getNext();
			} else {
				Node prev = get( i - 1 );
				n = prev.getNext();
				prev.setNext( prev.getNext().getNext() );
			}
		}
		return n;
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
	
	public LinkedList clone(){
		LinkedList list = new LinkedList();
		for(int i=0; i < size(); i++){
			list.add(get(i).getValue());
		}
		return list;
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
			build = build + list.getValue() + " \n";
			return createString(list.getNext(), build);
		}
		return build;
	}

}
