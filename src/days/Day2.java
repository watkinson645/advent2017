package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day2 {
	
	public static void main(String args[]) {
		String file = "inputs/day2input";
		Scanner scan = null;
		List<Integer> list = new ArrayList<Integer>();
		final int SIZE = 16;
		
		// scan all values into list of integers
		try {
			scan = new Scanner(new File(file + ".txt"));
			while(scan.hasNext()) {
				int value = scan.nextInt();
				list.add(value);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (list != null) {
				scan.close();
			}
		}
		
		// store all scanned valyes into a jagged array
		int[][] table = new int[SIZE][SIZE];
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				table[i][j] = list.get((i * SIZE) + j).intValue();
			}
		} 
		
		// Retrieve all largest and smallest numbers from every row
		int[][] VIN = new int[16][2];
		for(int i = 0; i < SIZE; i++) {
			int smallest = table[i][0];
			int largest = table[i][0];
			for (int j = 0; j < SIZE; j++) {
				if (table[i][j] > largest) {
					largest = table[i][j];
				} else if (table[i][j] < smallest) {
					smallest = table[i][j];
				}
			}
			VIN[i][0] = largest;
			VIN[i][1] = smallest;
		}
		
		// Calculate checksum
		int checksum = 0;
		for(int i = 0; i < SIZE; i++) {
			int large = VIN[i][0];
			int small = VIN[i][1];
			checksum += (large - small);
		}
		
		// DEBUG: Show all largest and smallest numbers of every row
		System.out.println("Largest and smallest numbers of every row: " + Arrays.deepToString(VIN));
		System.out.println("Total Checksum: " + checksum);
	}
}
