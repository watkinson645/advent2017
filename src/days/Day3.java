package days;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day3 {

	public static void main(String[] args) {
		int input = 289326;
		
		// PART 1: Using manhattan distance for a spiral array
		/*
		 * Formula: sqrt(input) = 537.blah rounded to 538
		 * 538 / 2 = 269
		 *  
		 * I am (538^2 - input) away from the centre along the edge
		 * which is 118
		 * 537 - 118 = 419
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of elements : ");
        int n = 0;
		try {
			n = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

        int A[][] = new int[n][n];
        int k = n*n, c1 = 0, c2 = n - 1, r1 = 0, r2 = n - 1;

        while(k >= 1) {
        	// 1. bottom right to bottom left
            for(int i = c2; i >= c1; i--) {
                A[r2][i] = k--;
            }
        	
            // 2. bottom left to top left
            for(int j = r2 - 1; j >= r1; j--) {
                A[j][c1] = k--;
            }
            
            // 3. top left to top right
        	for(int i = c1 + 1; i <= c2; i++) {
                A[r1][i] = k--;
            }
        	
        	// 4. top right to bottom right
            for(int j = r1 + 1; j <= r2 - 1; j++) {
                A[j][c2] = k--;
            }

         c1++;
         c2--;
         r1++;
         r2--;
        }
        

        /* Printing the Circular matrix */
        System.out.println("The Circular Matrix is:");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
            	System.out.print(A[i][j]+ "\t");
            }
            System.out.println();
        }
        
        // PART 2:
        
	}
}
