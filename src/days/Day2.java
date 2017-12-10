package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class Day2 implements advent {
	
	private String file = "day2input";
	private List<Integer> list;
	private int[][] table;
	private int checksum, checksumV2;
	private int row = 16, column = 16;
	
	@Test
	public void runInputTestPart1() {
		loadFile(file);
		convertToTableArray(row, column);
		part1(row, column);
		printToScreen("a");
	}

	@Test
	public void runInputTestPart2() {
		loadFile(file);
		convertToTableArray(row, column);
		part2(row, column);
		printToScreen("b");
	}

	@Test
	public void runEx1Test() {

	}

	@Override
	public void loadFile(String filename) {
		Scanner scan = null;
		list = new ArrayList<Integer>();
		try {
			scan = new Scanner(new File("inputs/" + filename + ".txt"));
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
	}
	
	public void convertToTableArray(int row, int column) {
		// store all scanned values into a jagged array
		table = new int[row][column];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				table[i][j] = list.get((i * column) + j).intValue();
			}
		}
	}
	
	/*
	 * Calculate the sum of the difference between the largest and smallest numbers in each row
	 */
	public void part1(int row, int column) {
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
		
		checksum = 0;
		for(int i = 0; i < row; i++) {
			int large = VIN[i][0];
			int small = VIN[i][1];
			checksum += (large - small);
		}
	}
	
	/*
	 * Calculate the sum of the evenly divisible numbers in each row
	 */
	public void part2(int row, int column) {
		checksumV2 = 0;
		for(int i = 0; i < row; i++) {
			//System.out.println("Row to be calculated: " + (i + 1));
			for(int j = 0; j < column; j++) {
				int currentNo = table[i][j];
				//System.out.println("Number to be divided: " + currentNo);
				for(int k = 0; k < column; k++) {
					int iterNo = table[i][k];
					//System.out.println(currentNo + " / " + iterNo);
					float divide = (float) currentNo / iterNo;
					//System.out.println("Result: " + divide);
					
					if (divide == (int) divide && currentNo != iterNo) {
						//System.out.println("Number added to checksumV2: " + divide);
						checksumV2 += divide;
					}
				}
			}
		}
	}
	
	/*
	 * Debugging method to show checksum results for each part of the task
	 */
	public void printToScreen(String part) {
//		System.out.println("All Values: " + Arrays.deepToString(table));
//		System.out.println("Largest and smallest numbers of every row: " + Arrays.deepToString(VIN));
		if (part.equals("a")) {
			System.out.println("Total Checksum for Part 1: " + checksum);
		} else {
			System.out.println("Total Checksum for Part 2: " + checksumV2);
		}
	}
}
