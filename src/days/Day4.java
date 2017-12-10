package days;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class Day4 implements advent {
	
	private String file = "day4input";
	private String exFile = "day4ex1";
	private String[][] pass;
	private int[] isDupe, isDupeReverse;
	private int length, totalDupes, totalDupesReverse;
	
	@Test
	public void runInputTestPart1() {
		loadFile(file);
		part1();
		printToScreen("a");
		assertEquals(466, pass.length - totalDupes);
	}

	@Test
	public void runInputTestPart2() {
		loadFile(file);
		part2();
		printToScreen("b");
		assertEquals(251, pass.length - totalDupesReverse);
	}

	@Test
	public void runEx1Test() {
		loadFile(exFile);
		//printToScreen("c");
	}

	@Override
	public void loadFile(String filename) {
		Scanner scan = null;
		pass = new String[512][];

		String[] words = new String[]{};
		try {
			scan = new Scanner(new File("inputs/" + filename + ".txt"));
			for(int i = 0; i < 512; i++) {
				words = scan.nextLine().split(" ");
				pass[i] = words;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pass != null) {
				scan.close();
				length = pass.length;
			}
		}
	}
	
	/*
	 * Unused method to calculate the length of the file so that any size file
	 * can be used for this program.
	 */
	public void getLengthOfFile(String filename) {
		BufferedReader reader;
		File file = new File("inputs/" + filename + ".txt");
		try {
			reader = new BufferedReader(new FileReader(file));
			while(reader.readLine() != null) {
				length++;
			} reader.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
	}
	
	/*
	 * Counts the duplicate words in a file full of possible pass phrases
	 */
	public void part1() {
		isDupe = new int[length];
		for(int i = 0; i < isDupe.length; i++) {
			isDupe[i] = 0;
		}
		
		for(int i = 0; i < length; i++) {
			int rowCount = 0;
			for(int j = 0; j < pass[i].length; j++) {
				for(int k = 0; k < pass[i].length; k++) {
					if (j != k && pass[i][j].equals(pass[i][k])) {
						rowCount++;
					}
				}
			}
			if (rowCount > 0) {
				isDupe[i] = 1;
			}
		}
	}
	
	/*
	 * Checks whether the passphrases from part 1 have words that
	 * can have their characters rearrange to form the other word(s)
	 * making the passphrase invalid
	 */
	public void part2() {
		isDupeReverse = new int[length];
		for(int i = 0; i < isDupeReverse.length; i++) {
			isDupeReverse[i] = 0;
		}
		
		for(int i = 0; i < length; i++) {
			int rowCountReverse = 0;
			for(int j = 0; j < pass[i].length; j++) {
				for(int k = 0; k < pass[i].length; k++) {
					if (j != k && matchChars(pass[i][j], pass[i][k])) {
						rowCountReverse++;
					}
				}
			}
			if (rowCountReverse > 0) {
				isDupeReverse[i] = 1;
			}
		}
	}
	
	/*
	 * Given two strings, it checks if the second string contains all the
	 * characters present in the first string.
	 * NOTE: logically both strings have to be of the same length for the
	 * above condition to be true 
	 */
	public boolean matchChars(String first, String second) {
		boolean outcome = false;
		int count = 0;
		for(int i = 0; i < first.length(); i++) {
			if (second.indexOf(first.charAt(i)) >= 0) {
				count++;
			}
		} if (count == second.length() && count == first.length()) {
			outcome = true;
		}
	    return outcome;
	}
	
	public void printToScreen(String part) {
		totalDupes = 0;
		totalDupesReverse = 0;
		if (part.equals("a")) {
			for(int i = 0; i < isDupe.length; i++) {
				if (isDupe[i] == 1) {
					totalDupes++;
				}
			} System.out.println("Part 1 Result: " + (length - totalDupes));
		} else {
			for(int i = 0; i < isDupeReverse.length; i++) {
				if(isDupeReverse[i] == 1) {
					totalDupesReverse++;
				}
			} System.out.println("Part 2 result: " + (length - totalDupesReverse));
		}
	}

}
