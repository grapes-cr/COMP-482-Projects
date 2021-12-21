//Caitlin Rafael
//Project 3
//11/30/2021

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//get int, then int-1 becomes spot in array+1

public class Project3 {

	public static void main(String[] args) {
		int[] input = readInput();
		System.out.println(subArraySum(input, 0, input.length-1));
	}

	private static int[] readInput() {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("E:\\Users\\Caitlin\\eclipse-workspace\\Project 3\\src\\input"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find file.");
			System.exit(1);
		}
		int n = scan.nextInt(); 							// gets the N from the beginning of the txt file
		int[] input = new int[n];						    //makes array size n
		while (scan.hasNextInt()) {							//loops till no more ints in the input
			for (int i = 0; i < n; i++) {					//populate array
					input[i] = scan.nextInt();
			}		
		}
		return input;
	}

	private static int totalLeftRightSum(int[] input, int min, int mid, int max) { 
		int leftSum = -255, rightSum = -255, totalSum = 0; //accounts for negative sums
		
		for (int i = mid; i >= min; i--) { //checks the left half of the array
	         totalSum = totalSum + input[i];
	         if (totalSum > leftSum) {     //if leftSum[i] + leftSum[i+1] (in this case [i-1]) is larger than leftSum (meaning the next number isnt drastically negative) then update leftSum. 
	            leftSum = totalSum;
	         }
		}
		totalSum = 0; //reset totalSum to use for rightSum
		for (int j = mid + 1; j < input.length; j++) {
			totalSum += input[j];         
			if (totalSum > rightSum) {    //if rightSum[j] + rightSum[j+1] > rightSum[j] then update rightSum
				rightSum = totalSum;
			}
		}
		return Math.max((leftSum + rightSum), Math.max(leftSum, rightSum)); //return the max of eiher the left side, right side, or full array
	}
	
	private static int subArraySum(int[] input, int min, int max) {
		if (min == max) { //base case, when min reaches max return that value in the array
			return input[min];
		}
		int mid = (max+min)/2;
		return Math.max(Math.max(subArraySum(input, min, mid), subArraySum(input, mid + 1, max)), totalLeftRightSum(input, min, mid, max)); //recursively find the max sum by dividing in half
	}
}



