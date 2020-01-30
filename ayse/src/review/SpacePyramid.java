package review;

public class SpacePyramid {

	public static void main(String[] args) {
		
		 //    1 
	    //    12
	    //   123
	    //  1234
	    // 12345
	  
	        
	        for (int i = 1; i <= 5; i++) {
	            for (int j = 5 - i; j >= 1; j--) {
	                System.out.print(" ");
	            }
	            for (int m = 1; m <= i; m++) {
	                System.out.print(m);
	            }
	            System.out.println();
	        }
	    }
	}

	

		

	


