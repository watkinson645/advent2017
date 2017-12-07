package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day2 {
	
	public static void main(String args[]) {
		String file = "inputs/day2ex1";
		Scanner scan = null;
		List<Integer> list = new ArrayList<Integer>();
		int column = 4, row = 3;
		
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
		
		// store all scanned values into a jagged array
		int[][] table = new int[row][column];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				table[i][j] = list.get((i * column) + j).intValue();
			}
		} 
		
		// PART 1: 
		// Retrieve all largest and smallest numbers from every row
		int[][] VIN = new int[row][2];
		for(int i = 0; i < row; i++) {
			int smallest = table[i][0];
			int largest = table[i][0];
			for (int j = 0; j < column; j++) {
				if (table[i][j] > largest) {
					largest = table[i][j];
				} else if (table[i][j] < smallest) {
					smallest = table[i][j];
				}
			}
			VIN[i][0] = largest;
			VIN[i][1] = smallest;
		}
		
		// Calculate checksum: total of all rows' largest and smallest values subtracted
		int checksum = 0;
		for(int i = 0; i < row; i++) {
			int large = VIN[i][0];
			int small = VIN[i][1];
			checksum += (large - small);
		}
		
		// PART 2:
		// use the largest number and divide by each other value in array
		int checksumV2 = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				int currentNo = table[i][j];
			}
		}
		
		// DEBUG: Show all largest and smallest numbers of every row
		System.out.println("All Values: " + Arrays.deepToString(table));
//		System.out.println("Largest and smallest numbers of every row: " + Arrays.deepToString(VIN));
		System.out.println("Total Checksum for Part 1: " + checksum);
		System.out.println("Total Checksum for Part 2: " + checksumV2);
		
	}
}
