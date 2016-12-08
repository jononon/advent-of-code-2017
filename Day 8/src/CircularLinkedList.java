
public class CircularLinkedList {
	private CircularListNode head;
	private int size;
	
	public CircularLinkedList(boolean[] arr) {
		if(arr.length>0) {
			this.head = new CircularListNode(arr[0]);
			size++;
		}
		if(arr.length>1) {
			CircularListNode curr = this.head;
			for(int i = 1; i<arr.length; i++) {
				curr.setNext(new CircularListNode(arr[i], curr, null));
				curr = curr.getNext();
				size++;
			}
			curr.setNext(head);
			this.head.setLast(curr);
		}
	}
	
	public boolean[] toArray() {
		boolean[] arr = new boolean[size];
		CircularListNode curr = this.head;
		for(int i = 0; i<arr.length; i++) {
			arr[i] = curr.getValue();
			curr = curr.getNext();
		}
		return arr;	
	}
	
	public void moveHead(int steps) {
		for(int i = 0; i<steps; i++)
			head = head.getLast();
	}
}
