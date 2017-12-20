package main.java;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String input = scanner.nextLine();
		for (int i = 0; i < input.length(); i++) {
			for (int j = i + 1; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					System.out
							.println("Repeating characters found. Character " + input.charAt(i) +
									 " repeats and is in position " + i);
					return;
				}
				
			}
		}
		System.out.println("No repeating characters were found.");
	}
}
