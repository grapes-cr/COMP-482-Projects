//Caitlin Rafael
//Project 2
//11/8/2021

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//get int, then int-1 becomes spot in array+1

public class Project2 {

	public static void main(String[] args) {
		int[] inputs = readInput();
		sortAndPrint(inputs);
	}

	private static int[] readInput() {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("E:\\Users\\Caitlin\\eclipse-workspace\\Project 2\\src\\input"));
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

	private static void sortAndPrint(int[] input) { 
		int[] value = new int[input.length];                //make new array
		Arrays.fill(value, 1);                              //set all in the array to 1
		if (input[0] > input[1]) {                          //check if the first number is bigger than the second
			value[0]++;
		}

		for (int i = 1; i < input.length-1; i++) {
			if (input[i] > input[i-1]) {                    //checks if i is bigger than the previous number in input
				value[i] = value[i-1] + 1;
				if (value[i-1] == value[i]) {               //if value is equal to the one previous then increment the previous by one
					value[i-1]++;
				}
			}
			if (input[i] > input[i+1]) {                    //checks if i is bigger than next number
				value[i] = value[i+1] + 1;                  //only increment by one
				if (input[i] > (input[i-1])) {              //if i is bigger than both left and right, then i will be bigger than previous
					value[i] = value[i-1] + 1;
				}
			}
		}
			if (input[input.length - 1] > input [input.length - 2]) {
			value[input.length - 1] = value[input.length - 2] + 1; //check the last number in the input array
			}
			check(value, 1);
			outputSum(value);
	}
	
	private static void outputSum(int[] input) {
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
			System.out.print(input[i] + " ");
		}
		System.out.print("\n" + sum);
	}
	
	private static void check(int[] value, int spotInArray) { //checker loop to find any duplicates and change the 1st number in a sequence of duplicates (ex. 2 2 -> 3 2)
		while (spotInArray != value.length) {
			for (int c = spotInArray; c > 0; c--) {
				if (value[spotInArray-1] == value[spotInArray]) {
					value[spotInArray-1] = value[spotInArray] + 1;
					}
				}
			spotInArray++;	
		}
	}
}


