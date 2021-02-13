// Suppose I want to store an indefinite number of test scores and find their average and median 
// (if there is an even number of elements return the average of the two middle elements). 
// Implement this by using an arraylist or linked list, and assume the grades will be entered one at a time until the user enters “Done”. 
// (think carefully about which structure you pick)

import java.util.Scanner; 
import java.util.ArrayList;
	
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//                          MAIN CLASS
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
public class GradeArrayList { 

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//                          MAIN METHOD
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	public static void main(String[] arg) {

		int input = 0;
		int number = 0;
		
		Scanner in = new Scanner(System.in); // create scanner object
		
		ArrayList<Integer> gradeArray = new ArrayList<Integer>();
		
		// ***** couldn't figure out how to have Done complete the entering
		System.out.print("Keep entering new Grades. When finished enter '0'\n");
		
		while ((input = in.nextInt()) != 0) {
			gradeArray.add(input);
		}
			sortArray(gradeArray);
			printArrayList(gradeArray);	
			getCalcs(gradeArray);
		}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	//                        SORT ARRAY
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	// ******************
	// *** INCOMPLETE ***
	// ******************
	
	static void sortArray(ArrayList scores) {	// method that returns nothing, takes in ArrayList
	int temp = 0;
		ArrayList<Integer> sortArray = new ArrayList<Integer>();
		for (int i=0; i < scores.size(); i++) {
			if ((int) scores.get(i) > temp) {
//				sortArray.add(input);
			}
		}	
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -	
	//                       GET CALCULATIONS
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// ***** need a sorted array to find the median
	
	static void getCalcs(ArrayList scores) {	// method that returns nothing, takes in ArrayList
	int sum = 0;
	int num1 = 0;
	int num2 = 0;
	float tempNum2 = 0;
	for (int i=0; i < scores.size(); i++) { // get sum
		sum += (int) scores.get(i);
	}
		if (scores.size() % 2 == 0) {	// even				
			num1 = (int) scores.get((scores.size()/2) - 1);
			num2 = (int) scores.get(scores.size()/2);
			tempNum2 = num2;											// need to have one of the operands a float to get a float back
			System.out.println("median is: " + (num1 + tempNum2) / 2);	// median is average of the two middle numbers
		} else {	// odd
			float temp = sum;
			System.out.println("average is: " + temp/2);
			System.out.println("median is: " + (int) scores.get(scores.size() / 2));
		}
		System.out.println("sum is: " + sum);
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	//	                     PRINT THE LIST
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	static void printArrayList(ArrayList scores) {	// method that returns nothing, takes in ArrayList
		for (int i=0; i < scores.size(); i++) {
			System.out.println("array value: " + scores.get(i));
		}
	}
}

// for(int d : (int) scores)  // ***** not working - error (Type mismatch: cannot convert from element type Object to int)
//    sum += d;