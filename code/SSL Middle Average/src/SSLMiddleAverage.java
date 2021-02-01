// declare a singly list and head node
class LinkedList {
	ListNode head;
	
	public LinkedList(ListNode head) {	// constructor to put the head in the list
		this.head = head;
	} // linked list constructor
	public int get(int index) {			// define the get method 
		int counter = 0;
		ListNode current = head;
		
		while (counter < index) {
			current = current.next;
			counter ++;	
		}
		return current.data;		
	}
}  // linked list
class ListNode {						// Define Node class
	int data;
	ListNode next;
	
	public ListNode(int data) {			// constructor to set the data on the node that is being created
		this.data = data;
	} // list node constructor
} // list node
public class SSLMiddleAverage { 
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	             MAIN
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public static void main(String[] args) {
	  
		// build singly linked list
		ListNode node1 = new ListNode(1);	// create 1st node
		ListNode myHead = node1;			// set first node = head
		LinkedList myList = new LinkedList(myHead); // create new list
		
		ListNode node2 = new ListNode(3);		// keep adding nodes
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(9);
		ListNode node5 = new ListNode(12);
		ListNode node6 = new ListNode(15);	
		ListNode node7 = new ListNode(18);
//		ListNode node8 = new ListNode(21);		// use to test for even # of nodes
		
		node1.next = node2;		// assign pointer values
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
//		node7.next = node8;		// use to test for even
//		node8.next = null;		// use to test for even
		node7.next = null;		// use to test for odd
		
		middleAvg(myList);
	} // main
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// If the number of nodes is even, print the average
	// Else print the middle number’s data
	//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	static void middleAvg(LinkedList list) {		
		
		int totalInd = 0;
		float avg = 0;
		int num1 = 0;
		int num2 = 0;
		float tempNum2 = 0;
			
		// set the current node to the head
		ListNode current = list.head;
		ListNode pointer = list.head.next;
					
			while (pointer != null) {
//				System.out.println(current.data);		// use to see data

				pointer = current.next;
				current = current.next;				
				totalInd ++;
			} // while						
			
			if ((totalInd % 2) != 0) {		// If odd - print out middle number’s data
				System.out.println("middle index data: " + list.get(totalInd/2));	
			} else {						// print average of 2 middle numbers				
				num1 = list.get((totalInd/2) - 1);
				num2 = list.get((totalInd/2));
				tempNum2 = num2;			// need to have one of the operands a float to get a float back
				System.out.println("num1: " + num1 + " num2: " + num2 + " average: " + (num1 + tempNum2) / 2);
			}		
	} // middleAvg
} // SSL MiddleAverage