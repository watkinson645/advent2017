package day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

	public static void main(String args[]) {
		// scan file
		String filename = "day1input";
		Scanner scan = null;
		try {
			scan = new Scanner(new File("inputs/" + filename +".txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		
		// Store scan from file in string variable
		String input = null;
		while(scan.hasNext()) {
			input = scan.next();
		} scan.close();
		
		// add individual characters from scan into List<String>
		List<String> finalInput = new ArrayList<String>();  
		for (int i = 0; i < input.length(); i++) {
			String a_char = Character.toString(input.charAt(i)); 
			finalInput.add(a_char);
		}
		
		// convert List<String> to integer array
		int[] intList = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			intList[i] = Integer.valueOf(finalInput.get(i));
		}
		
		// check conditions and add to final total
		int total = 0;
		for (int i = 0; i < intList.length; i++) {
			// last number in stream: checks previous and first numbers
			if (i == intList.length - 1) {
				if (intList[i] == intList[0]) {
					total += intList[i];
				}
			// every other number
			} else {
				if (intList[i] == intList[i + 1]) {
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