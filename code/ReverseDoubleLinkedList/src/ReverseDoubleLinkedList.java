//declare double linked list itself and head node
class DblLinkedList {
	DblListNode head;

	public DblLinkedList(DblListNode head) {	// constructor to put the head in the list
		this.head = head;
	}  // linked list constructor
}   // linked list

class DblListNode {					// Define Node class
	DblListNode prev;				// Previous Node
	int data;						// Data for Node
	DblListNode next;				// Next Node
	
	public DblListNode(int data) {	// constructor to set the data on the node that is being created
		this.data = data;
	} // list node constructor
} // list node

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	                MAIN CLASS AND MAIN METHOD
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class ReverseDoubleLinkedList {	// body that matches program name
	public static void main(String[] arg) {
		DblListNode myHead = new DblListNode(1);  // create head
		DblLinkedList myList = new DblLinkedList(myHead);  // create new list called myList
		
		DblListNode node1 = new DblListNode(3);		// create all the nodes
		DblListNode node2 = new DblListNode(6);
		DblListNode node3 = new DblListNode(9);
		DblListNode node4 = new DblListNode(12);
		DblListNode node5 = new DblListNode(15);	
		
		// attach nodes to each other to create the list
		myHead.next = node1;	// assign pointer values to head
	
		node1.prev = myHead;	// assign previous node
		node1.next = node2;		// assign next node
		
		node2.prev = node1;
		node2.next = node3;
		
		node3.prev = node2;
		node3.next = node4;
		
		node4.prev = node3;
		node4.next = node5;
		
		node5.prev = node3;
		
		printList(myList);					// print list before reverse
		myList.head = reverse(myList);		// reverse pointers in list
		printList(myList);					// print list after reverse
		
		System.out.println("New Head:" + " " + reverse(myList));

} // main

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//          loop through list until null is reached
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
static DblListNode reverse(DblLinkedList list) {	// method that returns type DblListNode
	DblListNode result;								// define result of type DblListNode
	
	DblListNode prev = null;						// set 3 pointers
	DblListNode current = list.head;
	DblListNode next = null;
	
	while (current != null) {
		next = current.next;	// next = next node that current points to
		
		// only need to set previous and next on current node
		current.next = prev;	// current is set to point to previous node
		current.prev = next;	// set previous node on current node to next node
		
		// set nodes for next iteration
		prev = current;			// previous is set to current node
		current = next;			// current node = next node 
	}  // while
	result = prev;	// previous = new head
	return result;	// return new head
}   // reverse
	
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//                     print the list
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
static void printList(DblLinkedList list) {	// method that returns nothing, takes in list
	// set the current node to the head
	DblListNode previous = list.head;
	DblListNode pointer = list.head.next;
			
	while (pointer != null) {
		System.out.println(previous.data);
		pointer = previous.next;
		previous = previous.next;
	}  // while
}  // print list
} // reverse double linked list