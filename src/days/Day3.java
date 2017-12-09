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
	private int[][] spiralArray;
	private int size;
	
	@Test
	public void runTestPart1() {
		assertEquals(calculateManhattanDistance(input), 419);
	}
	
	@Test
	public void runTestPart2() {
		// typing in 11 shows the correct answer: 295299
		readUserInput();
		spiralPart2(spiralArray, size);
		displayArray();
	}
	
	public int calculateManhattanDistance(int number) {
		int sqrt = (int) Math.sqrt(number);
		int awayFromCentre = (sqrt + 1) * (sqrt + 1) - input;
		return sqrt - (awayFromCentre);
	}
	
	public void readUserInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the number of elements : ");
        size = 0;
		try {
			size = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

        spiralArray = new int[size][size];
	}
	
	/*
	 * Partial Code Source: https://ideone.com/0bWDJ7
	 * StackOverflow Thread: https://stackoverflow.com/questions/33684970/print-2-d-array-in-clockwise-expanding-spiral-from-center
	 */
	public void spiralPart2(int[][] matrix, int size) {
		int x = 0; // current x position
		int y = 0; // current y position
		int d = 0; // current direction: 0=RIGHT, 1=UP, 2=LEFT, 3=DOWN
		int c = 0; // counter
		int s = 1; // chain size
		
		x = matrix.length / 2;
		y = x;
		//System.out.println("X: " + x + ", Y: " + y);
		matrix[x][y] = 1;
		
		int value = 0;
		
		for(int k = 1; k <= (size - 1); k++) {
			for(int j = 0; j < ( k < (size - 1)?2:3); j++) {
				for(int i = 0; i < s; i++) {
					switch(d) {
						case 0: y = y + 1; 
								try {
									value = sumOfAdjacent(x, y);
								} catch (ArrayIndexOutOfBoundsException e) {
									value = 0;
								}
								matrix[x][y] = value;
								break;
						case 1: x = x - 1; 
								try {
									value = sumOfAdjacent(x, y);
								} catch (ArrayIndexOutOfBoundsException e) {
									value = 0;
								}
								matrix[x][y] = value;
								break;
						case 2: y = y - 1; 
								try {
									value = sumOfAdjacent(x, y);
								} catch (ArrayIndexOutOfBoundsException e) {
									value = 0;
								}
								matrix[x][y] = value;
								break;
						case 3: x = x + 1; 
								try {
									value = sumOfAdjacent(x, y);
								} catch (ArrayIndexOutOfBoundsException e) {
									value = 0;
								}
								matrix[x][y] = value;
								break;
					}
				}
				d = (d + 1) % 4;
			}
			s = s + 1;
		}
	}
	
	/*
	 * Partial Source: https://gist.github.com/anonymous/2809ea3548f4e8513a0864f84e3aa3da
	 */
	public int sumOfAdjacent(int x, int y) {
		int sum = 0;
		sum += spiralArray[x + 1][y];
		sum += spiralArray[x + 1][y + 1];
		sum += spiralArray[x][y + 1];
		sum += spiralArray[x - 1][y + 1];
		sum += spiralArray[x - 1][y];
		sum += spiralArray[x - 1][y - 1];
		sum += spiralArray[x][y - 1];
		sum += spiralArray[x + 1][y - 1];
		return sum;
	}
	
	public void displayArray() {
		// Printing the Circular matrix
        System.out.println("The Circular Matrix is:");
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
            	System.out.print(spiralArray[i][j]+ "\t");
            }
            System.out.println();
        }
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
