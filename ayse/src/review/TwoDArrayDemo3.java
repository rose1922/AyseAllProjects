package review;

import java.util.Scanner;

public class TwoDArrayDemo3 {

	public static void main(String[] args) {
		
		
		 int[][] b = { 
	                { 7, 3, 5 }, 
	                { 9, 4, 2, 6 }, 
	                { 8, 1, 0, 3, 4 }, 
	                { 3, 5, 1 } 
	        };
//	      System.out.println(b.length);
//	      System.out.println(b[0].length);
//	      System.out.println(b[2].length);
	        for (int i = 0; i < b.length; i++) {
	            for (int j = 0; j < b[i].length; j++) {
//	              if (j != 1 && (i != 1 && i != 3)) {
	                    System.out.print(b[i][j] + " ");
//	              }
	            }
	            System.out.println();
	        }
	      System.out.println("********************");
	      
	      
	      Scanner scan = new Scanner(System.in);
	        System.out.println("Please enter rows size");
	        int rows = scan.nextInt();
	        System.out.println("Please enter column size");
	        int cols = scan.nextInt();
	        String[][] names = new String[rows][cols];
	        // names.length = rows
	        // names.length = cols
	        // Entering into array
	        
	        for (int i = 0; i < rows; i++) {
	            System.out.println("Please enter names. You are at row number --> " + i);
	            for (int j = 0; j < cols; j++) {
	                System.out.println("Amigo, enter a name!");
	                names[i][j] = scan.next();
	            }
	        }
	        System.out.println("Lets print the names");
	        for (int i = 0; i < names.length; i++) {
	            for (int j = 0; j < names[0].length; j++) {
	                System.out.print(names[i][j] + " ");
	            }
	                System.out.println();
	        }
	        
	        
	        

	}

}
