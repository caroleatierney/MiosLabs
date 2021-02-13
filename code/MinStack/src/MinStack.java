// Suppose I want to create a stack object that returns the minimum element of the stack in constant time
// Implement a stack object that does this by modifying existing methods and creating new ones if necessary, 
// while still operating like a normal stack. (Hint: use 2 stacks)

//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//							DECLARE NODE
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
class StackNode {
	int val;
	StackNode next;
	
	public StackNode(int val) {	// constructor to set the data in the node that is being created
		this.val = val;
	}
} 

//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//						DECLARE STACKS
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
		StackNode oldTop = top;			// save current top
		top = new StackNode(val);		// create a new node which is set to value
		top.next = oldTop;				// points new top node to last top
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                      POP METHOD
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public int pop() {					// method that takes the top node off of the list
		int value = 0;

        if(top == null){
            System.out.println("Empty stack.");
            return (Integer) null;
        } else {
			value = top.val;			// save the value of node removing
			top = top.next;				// points new top node to last top
		}
		return value;
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                     PEEK METHOD
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    public int peek() {
    	
        if(top == null){
            System.out.println("Empty stack.");
            return (Integer) null;
        }
        else{
            return top.val;
        }
    }
}  // LinkedListStack

//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//							MAIN CLASS
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class MinStack { 

	//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//							MAIN METHOD
	//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public static void main(String[] arg) {
		
		LinkedListStack mainStack = new LinkedListStack(); // instantiate Linked List Stack

		mainStack.push(mainStack, 89);
		mainStack.push(mainStack, 6);
		mainStack.push(mainStack, 7);
		mainStack.push(mainStack, 14);
		mainStack.push(mainStack, 2);
		mainStack.push(mainStack, 10);
		mainStack.push(mainStack, 5);
		mainStack.push(mainStack, 99);
		mainStack.push(mainStack, 33);
		
		printStack(mainStack);	
		
		System.out.println("smallest: " + findSmallest(mainStack));
	
	} // main

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                      SMALLEST
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// method that takes the top node off of the list
	// adds to other list to maintain list
	// returns smallest element
	public static int findSmallest(LinkedListStack myStack) {

		LinkedListStack newStack = new LinkedListStack(); // instantiate Linked List Stack
		int leastVal = myStack.peek();
//		System.out.println("peek: " + leastVal);
		int temp = 0;
		
		while (myStack.top != null) {
		//	pop from main and push to newMain
		//	save smallest element
			temp = myStack.pop();
			if (temp < leastVal) {
				leastVal = temp;							
			}
			newStack.push(myStack, temp);
//			System.out.println("temp: " + temp);
		}
		
		return leastVal;
	}  // smallest
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                     PRINT THE STACK
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public static void printStack(LinkedListStack stackList) {	// method that returns nothing, takes in list
		StackNode temp = stackList.top;
	
		while (temp != null) {
//			System.out.println("stack node data: " + temp.val);
				temp = temp.next;
			} 
		}  // print stack	
} // MinStack