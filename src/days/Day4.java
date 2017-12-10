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
	private String[][] pass;
	private int[] isDupe;
	private int length, totalDupes;
	
	@Test
	public void runInputTestPart1() {
		loadFile(file);
		part1();
		printToScreen();
		assertEquals(466, pass.length - totalDupes);
	}

	@Test
	public void runInputTestPart2() {

	}

	@Test
	public void runEx1Test() {

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
	
	public void part2() {
		
	}
	
	public void printToScreen() {
		totalDupes = 0;
		for(int i = 0; i < isDupe.length; i++) {
			if (isDupe[i] == 1) {
				totalDupes++;
			}
		}
		System.out.println(length - totalDupes);
	}

}
