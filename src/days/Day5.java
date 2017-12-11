package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class Day5 implements advent {
	
	String file = "day5input";
	List<Integer> jumps;
	int steps;
	
	/* Part 1 Example
	 *i:0  1  2  3   4  5 
	 * (0) 3  0  1  -3 
	 * (1) 3  0  1  -3
	 *  2 (3) 0  1  -3
	 *  2  4  0  1 (-3)
	 *  2 (4) 0  1  -2
	 *  2  5  0  1  -2 EXIT
	 *  Count how many steps required
	 */
	
	@Test
	public void runInputTestPart1() {
		loadFile(file);
		part1();
		printToScreen();
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
		jumps = new ArrayList<Integer>();
		try {
			scan = new Scanner(new File("inputs/" + filename + ".txt"));
			while (scan.hasNextLine()) {
				jumps.add(scan.nextInt());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Had a version which I believed should have worked but didn't. Googled a version that worked :/
	 * Credit to: snarkbait
	 * Link: https://gist.github.com/snarkbait/08300394caef4ae36d01762d4d8b7460
	 */
	public void part1() {
		int[] a = new int[jumps.size()];
		for(int i = 0; i < jumps.size(); i++) {
			a[i] = jumps.get(i);
		}
		
        int current = 0;
        steps = 0;

        while (current < jumps.size() && current >= 0) {
            int jump = a[current]++;
            current += jump;
            steps++;
        }
    }
	
	public void part2() {
		
	}
	
	public void printToScreen() {
		System.out.println("Amount of steps taken: " + steps);
	}

}
