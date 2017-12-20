package application;

import application.calculator.ProcessDate;

import java.util.Scanner;

//Code works. LOTS of refactoring potential!
public class InputReceiver {
	
	//Runs the app
	public static void main(String[] args) {
		System.out.println("Enter the date as YYYY MM DD: ");
		Scanner scanner = new Scanner(System.in);
		int[] dateArray = new int[3];
		for (int i = 0; i < dateArray.length; i++) {
			dateArray[i] = scanner.nextInt();
		}
		ProcessDate dateProcessor = new ProcessDate(dateArray);
		dateProcessor.getDayOfTheWeek();
		
		
	}
}
