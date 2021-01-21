
/*********************************************************************
 * A linked list is one of the many self-referential data structures
 * in which there is a pointer that points to an strucutre of the same
 * type.
 * 
 *  ----------------      ----------------      ----------------
 *  | data | next -|----> | data | next -|----> | data | next X|
 *  ----------------      ----------------      ----------------   
 *  
 */
public class linkedlist<T extends Comparable<T>>{
    Node<T> head;
    /* **************************************************
    * inner class Node that stores the data of each Node
    * and the pointer to the next Node in the list
    */
    class Node<T>{
        Node<T> next;
        T data;
        Node(T data){
            this.data=data;
            this.next=null;
        }
    }

/********************************************************************
 * clear() deletes all the elements in the linked list by setting the
 *  head Node to null.
 * Though not necessary, calling System.gc() removes all the unused 
 * objects, in this case, Nodes to clear memory from the JVM
 * ******************************************************************/
public void clear(){
    head=null;
    System.gc();
}
/*********************************************
 * size() returns the size of the linked list
 * O(n)
 */
public int size(){
    Node<T> current=head;
    int length=0;
    while(current != null){
        length++;
        current=current.next;
    }
    return length;
}
/**********************************************
 * show() prints out the linked list
 * O(n)
 */
public void show(){
    Node<T> current = head;
    // check if list is empty
    if(current == null)
        System.out.println("Empty list");
    else{
    //loop until end of list is reached
    while(current.next != null){
        System.out.print(current.data+" -> ");
        //go to the next Node
        current = current.next;
    }
    
    //print out the last Node
    System.out.println(current.data);
}
}
/*************************************************************
 * addFirst(T value) method adds the value at the front of 
 * the list
 * O(1)
 */
public boolean addFirst(T value){
    Node<T> newValue= new Node<T>(value);
    //set the newValue node to be the head Node
    newValue.next=head;
    head=newValue;
    return true;
}
/**********************************************************
 * addToEnd(T d) adds an element to the end of the linked list
 * O(n)
 */
public boolean addToEnd(T d){
    Node<T> end = new Node<T>(d);
    if(head==null){
        head=end;
        return true;
    }
    Node<T> current = head;
    
    while(current.next != null){
        current = current.next;
    }
    current.next = end;
    System.out.println(d.toString()+" appended to tail!");
    return true;
}

/*****************************************************
 * addAt(T value, int index) adds the given value at
 * the given index in the linked list
 * O(n)
 */
public boolean addAt(T value,int index){
    Node<T> end = new Node<T>(value);
    Node<T> current = head;
    int jump;
    int listCount = this.size();

    if(index>listCount || index<1){
        System.out.println("Add Failed: index out of bounds of size of linked list!!");
        return false;
    }
    else{
        jump = 0;
        while(jump<index-1){
            
            current = current.next;
            jump++;
        }
        
        end.next = current.next;
        current.next = end;
        listCount++;
        System.out.println("Success! "+value.toString()+" added at index "+index);
        return true;
    }
}
/*************************************************
 * deleteNodeWithData(T d) deletes the first Node
 * with the first occurence of vlaue d
 * O(n)
 */
public boolean deleteNodeWithData(T d){
    Node<T> current = head;
    while(current.next!=null){
        if(current.next.data.compareTo(d)==0){
            current.next = current.next.next;
            System.out.println("Success! Node with data "+d+" deleted.");
            return true;
        }
        current = current.next;
    }
    System.out.println("Delete Failed: No node found with given data!");
    return false;
}
/*************************************************************
 * deleteNodeAtIndex(int index) traverses the linked list
 * until you reach the requested index and deletes that Node
 * O(n)
 */
public boolean deleteNodeAtIndex(int index){
    Node<T> current = head;
    int jump;
    int listCount=this.size();
    if(index>listCount || index<1){
        System.out.println("Delete Failed: index out of bounds of size of linked list!!");
        return false;
    }    	
    else{
        jump=0;
        while(jump<index-1){
            current = current.next;
            jump++;
        }
        current.next = current.next.next;
        System.out.println("Success! Node at index "+index+" deleted.");
        listCount--;
        return true;
    }

}



public static void main(String[] args){
    //creating a linked list of integers
    linkedlist<Integer> myList= new linkedlist<>();
    myList.addFirst(0);
    myList.addToEnd(1);
    myList.addToEnd(3);
    //adding a 2 in between 1 and 3
    myList.addAt(2,2);
    //printing linked list
    myList.show();
    System.out.println("size of list: " + myList.size());
    //deleting linked list
    myList.clear();
    myList.show();
    System.out.println("size of list: " + myList.size() + "\n");

    //creating a linked list of names
    linkedlist<String> names = new linkedlist<>();
    names.addFirst("Adam");
    names.addToEnd("Brian");
    names.addToEnd("Daniel");
    //adding Charlie in betweem Brian and Daniel
    names.addAt("Charlie",2);
    names.addToEnd("Eva");
    names.show();
    System.out.println("size of list: "+ names.size() + "\n");
    //deleting Brian from the linked list
    names.deleteNodeWithData("Brian");
    names.show();
    System.out.println("size of list: " + names.size());
}
}