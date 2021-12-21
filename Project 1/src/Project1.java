//Caitlin Rafael
//Project 1
//9/30/2021

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//get int, then int-1 becomes spot in array+1

public class Project1 {

	public static void main(String[] args) {
		int[][] inputs = readInput();
		sortAndPrint(inputs);
	}

	private static int[][] readInput() {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("C:\\Users\\Caitlin\\eclipse-workspace\\Project 1\\src\\input.TXT"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find file.");
			System.exit(1);
		}
		int n = scan.nextInt(); 							// gets the N from the beginning of the txt file
		int[][] input = new int[n][n];						//makes 2d array size n*n
		while (scan.hasNextInt()) {							//loops till no more ints in the input
			for (int j = 0; j < n; j++) {					//nested for loops for 2d array, i put j first sorry
				for (int i = 0; i < n; i++) {
					input[j][i] = scan.nextInt();
				}
			}		
		}
		return input;
	}

	private static void sortAndPrint(int[][] input) { 
		int[][] temp = new int[input.length][input.length]; //make new array so we dont override input
		for (int j = 0; j < input.length; j++) { 			//more nested for loops to populate new 2d array									
			for (int i = 0; i < input.length; i++)
			temp[j][input[j][i] - 1] = i + 1;				//populates each row with the new ranking of the men: whichever int is read,  
		}													//int-1 position in temp will become the original int's spot in input (ex. int is 5 in index 0: temp[row][5-1] = 0+1. 5 is ranked 1st) 
		output(temp);
	}

	private static void output(int[][] input) {
		for (int j = 0; j < input.length; j++) {
			for (int i = 0; i < input.length; i++) {
				System.out.print(input[j][i] + "\t"); 		//just output temp in a for loop
			}
			System.out.println();							//lines
		}
	}
}
