//Caitlin Rafael
//Project 4
//12/15/2021

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//get int, then int-1 becomes spot in array+1

public class Project4 {

	public static void main(String[] args) {
		int[] inputs = readInput();
		sum(inputs);
	}

	private static int[] readInput() {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("E:\\Users\\Caitlin\\eclipse-workspace\\Project 4\\src\\input"));
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

	private static void sum(int[] input) {					
        int sum[] = new int[input.length];
        for(int i = 0; i < input.length; i++) {
                if(i == 0) {
                        sum[0] = input[0];
                } else if(i == 1) {
                        sum[1] = Math.max(sum[0],input[1]);
                } else {
                        sum[i] = Math.max(sum[i-2]+input[i],sum[i-1]);
                }
        }
        System.out.println(sum[sum.length-1]);
	}
	
}





