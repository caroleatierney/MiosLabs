// Suppose I want to store an indefinite number of test scores and find their average and median 
// (if there is an even number of elements return the average of the two middle elements). 
// Implement this by using an arraylist or linked list, and assume the grades will be entered one at a time until the user enters “Done”. 
// (think carefully about which structure you pick)

import java.util.Scanner; 
import java.util.ArrayList;
	
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//                          MAIN CLASS
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class Grades { 

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//                          MAIN METHOD
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public static void main(String[] arg) {
		
		ArrayList<Integer> gradeArray = new ArrayList<Integer>();

		Scanner myObj = new Scanner(System.in); // create scanner object
		System.out.println("Keep entering grades. When you are finished, enter Done");
		
		
		printArrayList(gradeArray);	
	}

		
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                     PRINT THE LIST
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	static void printArrayList(ArrayList scores) {	// method that returns nothing, takes in ArrayList
		System.out.println("xxxxxxxxxxx: ");
	}
}


//for (var i = 0; i < scoreList.length; i++) {

//	current = current.next;
//} 