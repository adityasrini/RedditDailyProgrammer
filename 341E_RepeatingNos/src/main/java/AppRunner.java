package main.java;

import java.util.HashMap;

public class AppRunner {
	public static void main(String[] args) {
		String input = "11111011110111011";
		int counter;
		int flag = 0;
		System.out.println(input);
		HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
		for (int i = 0; i + 2 < input.length(); i++) {
			String checker = input.charAt(i) + "" + input.charAt(i + 1);
			if (stringIntegerHashMap.containsKey(checker)) {
				System.out.println(checker + " is being skipped");
				continue;
			}
			String subString = input.substring(i + 2);
			System.out.println(checker + " " + subString);
			counter = 1;
			while (subString.contains(checker) && flag < 2) {
				System.out.println(
						"Substring " + subString + " contains checker : " + checker + " at location " +
						subString.indexOf(checker) + " with counter " + ++counter);
				if (subString.substring(subString.indexOf(checker) + 1).length() < 2) {
					subString.substring(subString.indexOf(checker));
					flag++;
					
				} else {
					subString = subString.substring(subString.indexOf(checker) + 1);
				}
				System.out.println("New substring " + subString);
				stringIntegerHashMap.put(checker, counter);
			}
		}
		System.out.println("results");
		stringIntegerHashMap.forEach((s, integer) -> System.out.println(s + " " + integer));
	}
}
