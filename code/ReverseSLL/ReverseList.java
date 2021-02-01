//  I took these notes from a Duke University coursera class

//  Note: a class is a template that tells you how to make objects
//  constructor: specifies how to create objects for the class
//  code is run when the object is created to initialize the class
//  it looks like a function but doesn't return anything
//  constructors are named the same as the class
//  declaring it as public means any code can use it
//  note - methods are functions that are inside of classes and return something
//  methods are called on an object and implicitly act on that object
//  static methods don't act on any particular instance in the class
//  just belong to the class in general
//  main is the starting point before any objects are created
//  once you have an object you can invoke methods on them
//  private means only this function can make changes to these fields	
	

// declare list and head node
class LinkedList {
	ListNode head;
	
	public LinkedList(ListNode head) {	// constructor to put the head in the list
		this.head = head;
	}  // linked list constructor
}   // linked list

// declare node class
class ListNode {						// Define Node class
	int data;
	ListNode next;

	public ListNode(int data) {			// constructor? method to set the data on the node that is being created
		this.data = data;
	} // list node constructor
} // list node
	

public class ReverseList {	// body that matches program name
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                          MAIN
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public static void main(String[] args) {
	  
	// build singly linked list
	ListNode myHead = new ListNode(1);  // create head
	LinkedList myList = new LinkedList(myHead);  // create new list
	
	ListNode node1 = new ListNode(3);		// keep adding nodes
	ListNode node2 = new ListNode(6);
	ListNode node3 = new ListNode(9);
	ListNode node4 = new ListNode(12);
	ListNode node5 = new ListNode(15);	
	
	myHead.next = node1;	// assign pointer values
	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;

    printList(myList);					// print list before reverse
    myList.head = reverse(myList);		// reverse pointers in list
    printList(myList);					// print list after reverse
	} // main

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//  recursively call reverse list until null is reached
	//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	static ListNode reverse(LinkedList list) {	// method that returns type ListNode
		ListNode result;						// define result of type ListNode
		
		ListNode prev = null;					// set 3 pointers
		ListNode current = list.head;
		ListNode next = null;
		
		while (current != null) {
			next = current.next;	// next = next node that current points to
			current.next = prev;	// current is set to point to previous node
			prev = current;			// previous is set to current node
			current = next;			// current node = next node 
		}  // while
		result = prev;	// previous = new head
		return result;	// return new head
	}   // reverse
		
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//                     print the list
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	static void printList(LinkedList list) {	// method that returns nothing, takes in list
		// set the current node to the head
		ListNode previous = list.head;
		ListNode pointer = list.head.next;
				
		while (pointer != null) {
			System.out.println(previous.data);
			pointer = previous.next;
			previous = previous.next;
		}  // while
	}  // printlist
} // reverse list