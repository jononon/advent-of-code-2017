
public class CircularListNode {
	private boolean value;
	private CircularListNode last;
	private CircularListNode next;
	
	public CircularListNode (boolean value) {
		this.value = value;
		this.last = null;
		this.next = null;
	}
	
	public CircularListNode (boolean value, CircularListNode last, CircularListNode next) {
		this.value = value;
		this.last = last;
		this.next = next;
	}
	
	public boolean getValue() { return this.value; }
	public CircularListNode getLast() { return this.last; }
	public CircularListNode getNext() { return this.next; }
	
	public void setValue (boolean value) { this.value = value; }
	public void setNext (CircularListNode next) { this.next = next; }
	public void setLast (CircularListNode last) { this.last = last; }
}
