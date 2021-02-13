//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//						DECLARE NODE
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class StackNode {
	int val;
	StackNode next;
		
	public StackNode(int val) {	// constructor to set the data in the node that is being created
		this.val = val;
	}
} 

//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//						DECLARE STACK
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class LinkedListStack {	
	StackNode top;	// top node

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                      PUSH METHOD
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// method that adds a node to the top of the stack
	// if the current top of stack is greater than the number 
	// being added, remove top and add back after adding lower number
	public void push(LinkedListStack myStack, int val) {	
		
		if (top == null || top != null && top.val <= val) {
			StackNode oldTop = top;			// save current top
			top = new StackNode(val);		// create a new node which is set to value
			top.next = oldTop;				// points new top node to last top
		} else {
			int greaterVal = myStack.pop();		// save the greater value
			myStack.push(myStack, val);			// insert the lesser value
			myStack.push(myStack, greaterVal);	// add greater value back in
		}
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                      POP METHOD
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public int pop() {					// method that takes the top node off of the list
		int value = 0;
		if (top != null) {
			value = top.val;			// save the value of node removing
			top = top.next;				// points new top node to last top
		}
		return value;
	}
}  // LinkedListStack
	
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//                       MAIN CLASS
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class MaxStack { 

//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//                       MAIN METHOD
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public static void main(String[] arg) {
		
		LinkedListStack myStack = new LinkedListStack(); // instantiate Linked List Stack
		
		myStack.push(myStack, 9);
		myStack.push(myStack, 6);
		myStack.push(myStack, 7);
		myStack.push(myStack, 14);
		myStack.push(myStack, 5);
		myStack.push(myStack, 10);
		myStack.push(myStack, 5);
		myStack.push(myStack, 99);
		
		printStack(myStack);	
		
	} // main
		
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                     PRINT THE STACK
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public static void printStack(LinkedListStack stackList) {	// method that returns nothing, takes in list
		StackNode temp = stackList.top;
		
		while (temp != null) {
			System.out.println("stack node data: " + temp.val);
			temp = temp.next;
		} 
	}  // print stack	
	
	
} // MaxStack

