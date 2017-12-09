package days;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class Day3 {
	/*
	 * Used David Buchan-Swanson's solution for Part 1.
	 * Found here: https://github.com/deecewan/advent/blob/master/2017/reason/src/three.re
	 */
	private int input = 289326;
	
	@Test
	public void runTestPart1() {
		assertEquals(calculateManhattanDistance(input), 419);
	}
	
	public int calculateManhattanDistance(int number) {
		int sqrt = (int) Math.sqrt(number);
		int awayFromCentre = (sqrt + 1) * (sqrt + 1) - input;
		return sqrt - (awayFromCentre);
	}
	
	public void part2() {
		
	}
	
	/*
	 * Main Source: http://www.guideforschool.com/1728514-java-program-to-print-a-variation-of-circular-spiral-matrix/
	 * This is an edited variation on the variation of a Circular Spiral Matrix found on the link above.
	 * The output is a jagged array rotating in a clockwise direction going from the outside bottom 
	 * right corner inwards to 1. It uses a user-entered number and prints the square in the stated format.
	 */
	public static void main(String[] args) {
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
        

        // Printing the Circular matrix
        System.out.println("The Circular Matrix is:");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
            	System.out.print(A[i][j]+ "\t");
            }
            System.out.println();
        }
	}
}
