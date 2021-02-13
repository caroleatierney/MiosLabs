import java.util.ArrayList;	// using an array in this code

// define hash node class
class HashNode {
	String key;
	String value;
	HashNode next;
}

public class HashTablePhone {
	//=================================================================
	//          				Main
	//=================================================================		
	public static void main(String[] args) {
		HashTablePhone table = new HashTablePhone();
		
		table.put("6177750725", "Carole");
		table.put("6178422223", "Mike");
		
		capacity();
	}
	//create a node of chains	
	private ArrayList<HashNode> phoneNums;
	private int numBuckets = 16;  // initial number of buckets 
	
	private float maxLoadFactor = (float) 0.5;
	private int growFactor = 2;  // Growth doubles
	private int size;
	
	public HashTablePhone() {
		phoneNums = new ArrayList<HashNode>();  // array of hash nodes
				
		//load array table with empty values
		for (int i = 0; i< numBuckets; i++) {
			phoneNums.add(null);
		}
		size = 0;  // initial size
	}
	//=================================================================
	//                        Put Method
	//=================================================================
	public void put(String key, String value) {
	
		int index = createHashCode(key);  // first make the index using phone number
		
		index = index % numBuckets;  // use modulus to make sure index falls in boundary
		
		tableNode head = phoneNums.get(index);  // set the new linked list node = to this index

		// traverse linked list until you find null so you know where to add it
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
	
		size++; // increment list each time you add to it
		head = phoneNums.get(index);
				
		HashNode newNode = new HashNode(key, value);
		newNode.next = head;  // make the new node point to head
		phoneNums.set (index, newNode);
	}

	////=================================================================
	////		                   Get Method
	////=================================================================
	public String get(String key) {
		int index = createHashCode(key);  	// first find the index using phone number				
		return phoneNums.get(index);		// return value from that index				
	}
	
	////=================================================================
	////		                   Capacity
	////=================================================================
	static Integer capacity() {
		int capacity = numBuckets;    // capacity = number of buckets in list 				
		return capacity;	// return value from that index				
	}

	//=================================================================
	//          Generate Hash Method
	//=================================================================
	public String createHashCode(String phoneNum int numBuckets) {
		int hash = 0;

		for (int i = numBuckets - 1; i > numBuckets - 3; i--) {
			 hash = hash + phoneNum[i];
		 }
		index = index % numBuckets;  // use modulus to make sure index falls in boundary
		System.out.println(hash);
		return hash;
	}
}
//The worst case would be if the very last value in the hash table is the value you are looking for, hence O(n) because it had to go through n values to get to it.

//*** I really am having a hard time with the hash table logic
//Yes load balancing will matter because the indices could be as high as 18 and the initial indices are less than that.
