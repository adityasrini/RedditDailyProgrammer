/*Clearly I botched my first run. Time to try again and keep goign at it.
Simplest Java solution at https://www.reddit.com/r/dailyprogrammer/comments/759fha/20171009_challenge_335_easy_consecutive_distance/do4icyd/
 */

import java.util.Arrays;
import java.util.Scanner;

public class Answer {
	static Scanner scan;
	static int readNumbers[];
	static int distanceCount;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		calculateDistance();
	}
	
	private static void calculateDistance() {
		readNumbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		for (int i = 0; i < readNumbers.length; i++) {
			for (int j = i + 1; j < readNumbers.length; j++) {
				if (readNumbers[i] + 1 == readNumbers[j] || readNumbers[i] - 1 == readNumbers[j]) {
					distanceCount += (j - i);
				}
			}
			
		}
		
		System.out.println(distanceCount);
	}
}
