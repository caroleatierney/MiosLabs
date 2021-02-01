
// Using a CLL implementation, write a method that reverses the CLL and returns the new head of the CLL. This head should be the tail of the initial CLL. 


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CLL {

}

// I took these notes from a Duke University coursera class

// Note: a class is a template that tells you how to make objects
	// constructor: specifies how to create objects for the class
	// code is run when the object is created to initialize the class
	// it looks like a function but doesn't return anything
	// constructors are named the same as the class
	// declaring it as public means any code can use it
	// note - methods are functions that are inside of classes and return something
	// methods are called on an object and implicitly act on that object
	// static methods don't act on any particular instance in the class
	// just belong to the class in general
	// main is the starting point before any objects are created
	// once you have an object you can invoke methods on them
	// private means only this function can make changes to these fields

package ReverseCCL;

public class CircularSinglyLinkedList {	
	class Node {						// Define Node class
		int data;
		Node next;

		public Node(int data) {			// method to set the data on the node that is being created
			this.data = data;
		}
//	};
		
	// create head and tail node	
	private Node head = null;
	private Node tail = null;	
	
	public void AddNode(int data) {		// constructor
		Node AddNode = new Node(data);	// creates an instance of the class as an object		
		if (head == null) {	
			head = AddNode;				// first time through the head (first node) is created	
		} else {
			tail.next = AddNode;		// > first time through the tail points to the new node
		}
		tail = AddNode; 				// the tail now becomes the new node
		tail.next = head;				// tail node will now point to the head node
	}
	
	private class SinglyLinkedList createSinglyLinkedList() {		// method build a circular linked list and assign data values
		
		CircularSinglyLinkedList CSLL = new CircularSinglyLinkedList();

		CSLL.AddNode(3);
		CSLL.AddNode(6);
		CSLL.AddNode(9);
		CSLL.AddNode(12);
		CSLL.AddNode(15);	
		
		return CSLL;
	}
	
	// print the list
	
	
	// Reverse the list 
	
	
	// print the reversed list
	
	// public class reverseCCL {}
}
}
	
	
	