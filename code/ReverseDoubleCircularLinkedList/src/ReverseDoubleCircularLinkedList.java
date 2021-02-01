// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//		                DECLARE NODE
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class Node {			// Define Node class
	Node prev;			// Previous Node
	int data;			// Data for Node
	Node next;			// Next Node

	public Node(int data) {	// constructor to set the data on the node that is being created
		this.data = data;
		this.next = null;
		this.prev = null;
	} // list node constructor
} // list node

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//		           DECLARE DOUBLE LINKED LIST
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class DblCircLinkedList {
	Node head;
	Node tail;
	int length;						

	public DblCircLinkedList() {	// constructor to put the head and tail in the list
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                      PUSH METHOD
	//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public void push(int val) {	// method that adds a node
		var newNode = new Node(val);
		if (this.length == 0) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;	// set current node's tail = new node 
			newNode.prev = this.tail;	// set newNode's previous pointer to current tail
			this.tail = newNode;		// set tail to the new node
			this.tail.next = this.head;	// in a circular linked list the tail points to the head
		}
		this.length++;
	}
	

}   // linked list	

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//		                     MAIN CLASS
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class ReverseDoubleCircularLinkedList {

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//                          MAIN METHOD
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public static void main(String[] arg) {
		DblCircLinkedList myList = new DblCircLinkedList();	// create new list called myList
		myList.push(0);
		myList.push(3);
		myList.push(6);
		myList.push(9);
		myList.push(12);
		myList.push(15);
		
		printList(myList);					// print list before reverse
		reverseList(myList);				// reverse list
		printList(myList);					// print list after reverse
				
	} // mainc

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                     PRINT THE LIST
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	static void printList(DblCircLinkedList list) {	// method that returns nothing, takes in list
		Node current = list.head;		// set the current to the head
		
		for (var i = 0; i < list.length; i++) {
//			System.out.println("current data: " + current.data + " current node" + current + " current next; " + current.next + " current previous; " + current.prev);
			System.out.println("node data: " + current.data);
			current = current.next;
		} 
		
	}  // print list
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                    REVERSE THE LIST
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	static Node reverseList(DblCircLinkedList list) {	// method that returns nothing, takes in list

		System.out.println("old head: " + list.head + " old head data: " + list.head.data);
		System.out.println("old tail: " + list.tail + " old tail data: " + list.tail.data);
		
		Node result = null;				// define result of type Node

		Node prev = null;				// set prev pointer (at beginning it is null)
		Node next = null;				// set next pointer
		Node current = list.head;		// set the current = head
		list.head = list.tail;			// reverse head and tail
		list.tail = current;		
		
		
		for (var i = 0; i < list.length; i++) {
//			System.out.println("current data: " + current.data + " current node" + current + " current next; " + current.next + " current previous; " + current.prev);

			prev = current.prev;	// save the previous pointer
			next = current.next;	// save the next pointer
						
			current.next = prev;	// make next point to previous
			current.prev = next;	// make previous point to next
			if (current.next == null) {
				current.next = list.head;	// circular list
			}
				current = next;			// set the current node = next node and repeat	
		} 
		
		result = current.next;		// previous = new head
		System.out.println("new head: " + list.head + " new head data: " + list.head.data);
		System.out.println("new tail: " + list.tail + " new tail data: " + list.tail.data);
		
		return result;	// return new head

	}  // reverse list
	

} // reverse double linked list