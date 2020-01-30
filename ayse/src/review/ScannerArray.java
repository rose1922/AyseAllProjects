package review;

import java.util.Scanner;

public class ScannerArray {

	public static void main(String[] args) {
		
		
		    // read the array size from the scanner
		    // create an array of integers
		    // insert values of integers from the scanner
		    // print the sum of all elements
		    
		              Scanner scan;
		         scan = new Scanner(System.in);
		        System.out.println("How many numbers do you want to enter?");
		        int size = scan.nextInt();
		        int[] array = new int[size];
		        for (int i = 0; i < size; i++) {
		            System.out.println("Enter a number:");
		            array[i] = scan.nextInt();
		        }
		        int sum = 0;
		        for (int i = 0; i < size; i++) {
		            sum += array[i];
		        }
		        System.out.println("The sum is " + sum);
		    }
		}
		
	


