// Suppose we had the following sorted array of test scores: {31,44,50,56,67,67,73,75,75,78,78,78,83,88,93,96}
// Create a linked list that contains this sorted collection of test scores, and insert the following test scores while keeping the scores sorted from least to greatest:
// {29,58,40,67,34,99}
// Print out the sorted linked list of scores at the end. (You may not use any kind of sorting algorithms or external methods). 

import java.util.Arrays;

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//		                DECLARE NODE
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class Node {			// Define Node class
	int data;			// Data for Node
	Node next;			// Next Node

	public Node(int data) {	// constructor to set the data on the node that is being created
		this.data = data;
		this.next = null;
	} // list node constructor
} // list node

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//		           DECLARE SINGLY LINKED LIST
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class LinkedScoreList {
	Node head;
	Node tail;
	int length;						

	public LinkedScoreList() {	// constructor to put the head and tail in the list
		this.head = null;
		this.tail = null;
		this.length = 0;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                      PUSH METHOD
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public void push(int val) {	// method that adds a node to the end of the list
		var newNode = new Node(val);	// instantiate a new node
		if (this.length == 0) {			// if list empty
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;	// set current node's tail = new node 
			this.tail = newNode;		// set tail to the new node
		}
		this.length++;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                    INSERT METHOD
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public void insert(Node current, Node next, int val) {	// method that adds a node
		// make current node point to new node and make new node point to next or null
		// new node points to what current points to
		// current points to new node	
	
		var newNode = new Node(val);	// instantiate a new node
		if (this.length == 0) {			// if list empty
			this.head = newNode;
			this.tail = newNode;
		} else if (val <= current.data) {	
			this.head = newNode;		// first in list, becomes new head
			newNode.next = current;		// set current node's tail = new node 
		} else if (val > current.data && current.next == null) {	// inserting at end of list
			this.tail = newNode;		// set tail to new node at end of list 
			current.next = newNode;		// current points to new node
		} else if (val > current.data && val <= current.next.data) {
			newNode.next = current.next;
			current.next = newNode;		// current points to new node
		}
		this.length++;
	}
	
}  // linked list
	
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//                          MAIN CLASS
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class InsertLinkedList { 

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//                          MAIN METHOD
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public static void main(String[] arg) {
		
		LinkedScoreList myList = new LinkedScoreList(); // instantiate singly linked list
		int[] scores = new int[] {31,44,50,56,67,67,73,75,75,78,78,78,83,88,93,96};

		listLogic(myList, scores);
		
		insertNodes(myList, 29);
		insertNodes(myList, 58);
		insertNodes(myList, 40);
		insertNodes(myList, 67);
		insertNodes(myList, 34);
		insertNodes(myList, 99);
		
		printList(myList);	
	} // main
		
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//                         LIST LOGIC
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// create a linked list using the Array
	static void listLogic(LinkedScoreList scoreList, int[] scoreArray) {		
						
		for (var i = 0; i < scoreArray.length; i++) {	
			scoreList.push(scoreArray[i]);
		}
	} // listLogic

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//                      INSERT NEW NODES
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// then insert new nodes in order:  {29,58,40,67,34,99}

	static void insertNodes(LinkedScoreList scoreList, int val) {		

		Node current = scoreList.head;
		Node next = current.next;
		
		for (var i = 0; i < scoreList.length; i++) {
						
			if (val <= current.data) {				
				scoreList.insert(current, next, val);	
				return;
			} else if (val > current.data && current.next == null) {
				scoreList.insert(current, next, val);	
				return;
			} else if (val > current.data && val <= current.next.data) {
				scoreList.insert(current, next, val);	
				return;			
			}			
			current = current.next;		// get next node
			next = current.next;		// save new next node
		}
		
	} // listLogic	
		
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                     PRINT THE LIST
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	static void printList(LinkedScoreList scoreList) {	// method that returns nothing, takes in list
		Node current = scoreList.head;		// set the current to the head
		
		for (var i = 0; i < scoreList.length; i++) {
			System.out.println("node data: " + current.data);
			current = current.next;
		} 
	}  // print list	
} // InsertLinkedist


// notes:
// example of how to declare and initialize and arrylist
// ArrayList<Integer> scores = new ArrayList<Integer>(Arrays.asList(31,44,50,56,67,67,73,75,75,78,78,78,83,88,93,96));