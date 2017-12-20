import java.util.*;

class MainRunner {
	
	//Initializing variables
	private int[] integerArray;
	private int result = 0;
	private Set repeatedNumbersList = new HashSet();
	
	int getResult() {
		return result;
	}
	
	private void setResult(int result) {
		this.result += result;
	}
	
	private int[] getIntegerArray() {
		return integerArray;
	}
	
	void setIntegerArray(int[] integerArray) {
		this.integerArray = integerArray;
	}
	
	private boolean getRepeatedNumbersList(int integerToCheck) {
		return repeatedNumbersList.contains(integerToCheck);
	}
	
	private void setRepeatedNumbersList(int integerToAdd) {
		repeatedNumbersList.add(integerToAdd);
	}
	
	//Main method
	
	public static void main(String[] args) {
		
		int[] integerArray = {1, 2, 3, 4};
		int[] forwardAndBackwardIntArray = {31, 63, 53, 56, 96, 62, 73, 25, 54, 55, 64};
		System.out.println(Arrays.toString(forwardAndBackwardIntArray));
		MainRunner mainRunner = new MainRunner();
		mainRunner.setIntegerArray(forwardAndBackwardIntArray);
		mainRunner.singleRowDistanceCalculator();
		System.out.println(mainRunner.getResult());
//		System.out.println(positiveOrNegativeSeries(integerArray, 3));
	}
	
	//Key Methods
	
	static String positiveOrNegativeSeries(int[] integerArray, int integerToCheck) {
		List<Integer> integerList = new ArrayList<>();
		for (int i : integerArray) {
			integerList.add(i);
		}
		for (int integer : integerList) {
			if ((integerToCheck - 1) == integer &&
				(integerList.indexOf(integerToCheck) < integerList.indexOf(integer))) {
				return "negative";
			}
			if ((integerToCheck + 1) == integer &&
				(integerList.indexOf(integerToCheck) < integerList.indexOf(integer))) {
				return "positive";
			}
		}
		return "not found";
	}
	
	void singleRowDistanceCalculator() {
		int[] integerArray = this.getIntegerArray();
		for (int i = 0, arrayLength = integerArray.length; i < arrayLength; i++) {
			int secondCounter = 0;
			int temp = integerArray[i];
			if (this.getRepeatedNumbersList(temp)) {
				continue;
			}
			System.out.println(integerArray[i]);
			System.out.println(positiveOrNegativeSeries(integerArray, integerArray[i]));
			String checker = positiveOrNegativeSeries(integerArray, integerArray[i]);
			switch (checker) {
				case "positive":
					forwardDistanceCalculator(arrayLength, secondCounter, temp, i);
					System.out.println(this.repeatedNumbersList.toString());
					System.out.println("Result at this stage: " + this.getResult());
					break;
				case "negative":
					reverseDistanceCalculator(arrayLength, secondCounter, temp, i);
					System.out.println(this.repeatedNumbersList.toString());
					System.out.println("Result at this stage: " + this.getResult());
					break;
				default:
				
			}
			
		}
		
		
	}
	
	private void forwardDistanceCalculator(int arrayLength, int secondCounter, int temp, int tempIndex) {
		
		for (int j = 0; j < arrayLength; j++) {
			if (temp == integerArray[j]) {
				secondCounter = 0;
			}
			if (temp + 1 == integerArray[j] && tempIndex < j) {
				this.setRepeatedNumbersList(temp);
				this.setRepeatedNumbersList(integerArray[j]);
				temp = integerArray[j];
				tempIndex = j;
				this.setResult(secondCounter);
				secondCounter = 0;
			}
			secondCounter++;
		}
		
	}
	
	private void reverseDistanceCalculator(int arrayLength, int secondCounter, int temp, int tempIndex) {
		
		for (int j = 0; j < arrayLength; j++) {
			if (temp == integerArray[j]) {
				secondCounter = 0;
			}
			if (temp - 1 == integerArray[j] && tempIndex < j) {
				this.setRepeatedNumbersList(temp);
				this.setRepeatedNumbersList(integerArray[j]);
				temp = integerArray[j];
				tempIndex = j;
				this.setResult(secondCounter);
				secondCounter = 0;
			}
			secondCounter++;
		}
		
	}
	
	
	//Outdated methods that are only here to document my thought and solution deriving process
	
	void forwardObjectDistanceCalculator() {
		Set<Integer> repeatedNumbersList = new HashSet<>();
		int[] integerArray = this.getIntegerArray();
		for (int i = 0, arrayLength = integerArray.length; i < arrayLength; i++) {
			int secondCounter = 0;
			int temp = integerArray[i];
			int tempIndex = i;
			if (repeatedNumbersList.contains(temp)) {
				continue;
			}
			for (int j = 0; j < arrayLength; j++) {
				if (temp == integerArray[j]) {
					secondCounter = 0;
				}
				if (temp + 1 == integerArray[j] && tempIndex < j) {
					repeatedNumbersList.add(temp);
					repeatedNumbersList.add(integerArray[j]);
					temp = integerArray[j];
					tempIndex = j;
					this.setResult(secondCounter);
					secondCounter = 0;
				}
				secondCounter++;
			}
			
		}
		
		
	}
	
	void reverseObjectDistanceCalculator() {
		Set<Integer> repeatedNumbersList = new HashSet<>();
		int[] integerArray = this.getIntegerArray();
		for (int i = 0, arrayLength = integerArray.length; i < arrayLength; i++) {
			int secondCounter = 0;
			int temp = integerArray[i];
			int tempIndex = i;
			if (repeatedNumbersList.contains(temp)) {
				continue;
			}
			for (int j = 0; j < arrayLength; j++) {
				if (temp == integerArray[j]) {
					secondCounter = 0;
				}
				if (temp - 1 == integerArray[j] && tempIndex < j) {
					repeatedNumbersList.add(temp);
					repeatedNumbersList.add(integerArray[j]);
					temp = integerArray[j];
					tempIndex = j;
					this.setResult(secondCounter);
					secondCounter = 0;
				}
				
				secondCounter++;
			}
			
		}
		
		
	}
	
	static int consecutiveNumberChecker(int[] integerArray) {
		int counter = 0;
		int temp = integerArray[0];
		
		for (int integer : integerArray) {
			if (temp + 1 == integer) {
				temp = integer;
				counter++;
			}
		}
		
		return counter;
		
	}
	
	static int firstDistanceChecker(int[] integerArray) {
		int temp = integerArray[0];
		int tally = 0;
		int secondCounter = 0;
		
		for (int i = 0; i < integerArray.length; i++) {
			if (temp == integerArray[i]) {
				secondCounter = 0;
			}
			if (temp + 1 == integerArray[i]) {
				temp = integerArray[i];
				tally = secondCounter;
			}
			secondCounter++;
		}
		
		return tally;
	}
	
	static int secondDistanceChecker(int[] integerArray) {
		int temp = integerArray[1];
		int tally = 0;
		int secondCounter = 0;
		
		for (int i = 0; i < integerArray.length; i++) {
			int anIntegerArray = integerArray[i];
			if (temp == anIntegerArray) {
				secondCounter = 0;
			}
			if (temp + 1 == anIntegerArray) {
				temp = anIntegerArray;
				tally = secondCounter;
			}
			secondCounter++;
		}
		
		return tally;
	}
	
	static int thirdDistanceChecker(int[] integerArray) {
		int temp = integerArray[2];
		int tally = 0;
		int secondCounter = 0;
		
		for (int i = 0; i < integerArray.length; i++) {
			if (temp == integerArray[i]) {
				secondCounter = 0;
			}
			if (temp + 1 == integerArray[i]) {
				temp = integerArray[i];
				tally = secondCounter;
			}
			secondCounter++;
		}
		
		return tally;
	}
	
	static int methodExtractedDistanceCalculator(int[] integerArray) {
		int result = 0;
		
		
		for (int temp : integerArray) {
			result += distanceChecker(temp, integerArray);
		}
		return result;
	}
	
	private static int distanceChecker(int temp, int[] integerArray) {
		int tally = 0;
		int secondCounter = 0;
		int tempIndex = 0;
		for (int i = 0; i < integerArray.length; i++) {
			if (temp == integerArray[i]) {
				tempIndex = i;
				secondCounter = 0;
			}
			if (temp + 1 == integerArray[i] && tempIndex < i) {
				temp = integerArray[i];
				tally = secondCounter;
			}
			secondCounter++;
		}
		
		return tally;
	}
	
	static int iteratingListDistanceCalculator(int[] integerArray) {
		int tally = 0;
		Set<Integer> repeatedNumbersList = new HashSet<>();
		
		for (int i = 0, arrayLength = integerArray.length; i < arrayLength; i++) {
			int secondCounter = 0;
			int temp = integerArray[i];
			int tempIndex = i;
			if (repeatedNumbersList.contains(temp)) {
				continue;
			}
			for (int j = 0; j < arrayLength; j++) {
				if (temp == integerArray[j]) {
					secondCounter = 0;
				}
				if (temp + 1 == integerArray[j] && tempIndex < j) {
					repeatedNumbersList.add(temp);
					repeatedNumbersList.add(integerArray[j]);
					temp = integerArray[j];
					tempIndex = j;
					tally += secondCounter;
					secondCounter = 0;
				}
				secondCounter++;
			}
			
		}
		
		
		return tally;
	}
}
