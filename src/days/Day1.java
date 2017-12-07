package days;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

	public static void main(String args[]) {
		// scan file
		String filename = "inputs/day1input";
		Scanner scan = null;
		String input = null;
		try {
			scan = new Scanner(new File(filename +".txt"));
			
			while(scan.hasNext()) {
				input = scan.next();
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				scan.close();
			}
		}
		int length = input.length();
		
		// add individual characters from scan into List<String>
		List<String> finalInput = new ArrayList<String>();  
		for (int i = 0; i < length; i++) {
			String a_char = Character.toString(input.charAt(i)); 
			finalInput.add(a_char);
		}
		
		// convert List<String> to integer array
		int[] intList = new int[length];
		for (int i = 0; i < length; i++) {
			intList[i] = Integer.valueOf(finalInput.get(i));
		}
		
		// PART 1:
		// check conditions and add to final total (adjacent character is a match)
		int total = 0;
		
//		for (int i = 0; i < length; i++) {
//			// last number in stream: checks previous and first numbers
//			if (i == length - 1) {
//				if (intList[i] == intList[0]) {
//					total += intList[i];
//				}
//			} else {
//				if (intList[i] == intList[i + 1]) {
//					total += intList[i];
//				}
//			}
//		}
		
		// PART 2:
		// check conditions and add to final total (characters halfway round is a match)
		int step = intList.length / 2;
		for (int i = 0; i < intList.length; i++) {
			// if i is larger than the step
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
		
		// DEBUG: Print integer results to screen
		System.out.print("Input: ");
		for (int i : intList) {
			System.out.print(i);
		}
		System.out.println("");
		System.out.println("Output: " + total);
	}

}