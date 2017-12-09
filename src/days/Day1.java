package days;

import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class Day1 implements advent {
	
	private String inputFile = "day1input";
	private String exFile = "day1ex1";
	private String file;
	private int length, total;
	private List<String> input = new ArrayList<String>();
	private int[] intList;
	
	@Override
	@Test
	public void runInputTestPart1() {
		loadFile(inputFile);
		convertFileToArray();
		part1();
		assertEquals(total, 1251);
		//printToScreen();
	}

	@Override
	@Test
	public void runInputTestPart2() {
		loadFile(inputFile);
		convertFileToArray();
		part2();
		assertEquals(total, 1244);
		//printToScreen();
	}

	@Override
	@Test
	public void runEx1Test() {
		loadFile(exFile);
		convertFileToArray();
		part1();
		assertEquals(total, 9);
		//printToScreen();
	}

	@Override
	public void loadFile(String filename) {
		Scanner scan = null;
		try {
			scan = new Scanner(new File("inputs/" + filename + ".txt"));
			while(scan.hasNext()) {
				file = scan.next();
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				scan.close();
			}
		}
	}
	
	/*
	 * Loads the file into an ArrayList and converts it to an array
	 */
	public void convertFileToArray() {
		length = file.length();
		for (int i = 0; i < length; i++) {
			String a_char = Character.toString(file.charAt(i)); 
			input.add(a_char);
		}

		intList = new int[length];
		for (int i = 0; i < length; i++) {
			intList[i] = Integer.valueOf(input.get(i));
		}
	}
	
	/*
	 * Checks the adjacent number in stream and adds it to total if it matches
	 */
	public void part1() {
 		for (int i = 0; i < intList.length; i++) {
 			if (i == intList.length - 1) {
 				if (intList[i] == intList[0]) {
 					total += intList[i];
 				}
 			} else {
 				if (intList[i] == intList[i + 1]) {
 					total += intList[i];
 				}
 			}
 		}
	}
	
	/*
	 * Checks the number that is halfway round in the stream and adds it
	 * to the total if it is the same
	 */
	public void part2() {
		int step = intList.length / 2;
		for (int i = 0; i < intList.length; i++) {
			if (i >= step) {
				int temp = intList.length - i;
				int j = step - temp;
				if (intList[i] == intList[j]) {
					total += intList[i];
				}
			} else {
				if (intList[i] == intList[i + step]) {
					total += intList[i];
				}
			}
		}
	}
	
	// DEBUG: Print integer results to screen
	public void printToScreen() {
		System.out.print("Input: ");
		for (int i : intList) {
			System.out.print(i);
		} System.out.println("");
		System.out.println("Output: " + total);
	}
}