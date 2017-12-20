import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTester {
	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private static MainRunner mainRunner = new MainRunner();
	private static int[] forwardAndBackwardIntArray = {31, 63, 53, 56, 96, 62, 73, 25, 54, 55, 64};
	
	
	@BeforeAll
	@Disabled
	static void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	@AfterAll
	@Disabled
	static void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}
	
	@Test
	@Disabled
	void soutTester() {
		System.out.println("Hi!");
		assertEquals("Hi!\n", outContent.toString());
	}
	
	@Nested
	class ConsecutiveNumberTests {
		
		@Test
		void whenTwoNumbersAreGivenDetermineConsecutiveNumber() {
			int[] integerArray = {1, 2};
			int counter = MainRunner.consecutiveNumberChecker(integerArray);
			assertEquals(1, counter);
		}
		
		@Test
		void whenThreeNumbersAreGivenDetermineConsecutiveNumber() {
			int[] integerArray = {1, 3, 2};
			int counter = MainRunner.consecutiveNumberChecker(integerArray);
			assertEquals(1, counter);
		}
		
		@Test
		void whenMultipleNumbersAreGivenDetermineConsecutiveNumberOfStartingSeries() {
			int[] integerArray = {1, 3, 2, 3, 5, 3, 6, 4};
			int counter = MainRunner.consecutiveNumberChecker(integerArray);
			assertEquals(3, counter);
		}
		
	}
	
	@Nested
	class ForwardDistanceTests {
		@Test
		void whenTwoNumbersAreGivenDetermineDistance() {
			int[] integerArray = {1, 2};
			int counter = MainRunner.firstDistanceChecker(integerArray);
			assertEquals(1, counter);
		}
		
		@Test
		void whenThreeNumbersAreGivenDetermineDistance() {
			int[] integerArray = {1, 3, 2};
			int counter = MainRunner.firstDistanceChecker(integerArray);
			assertEquals(2, counter);
		}
		
		@Test
		void whenMultipleNumbersAreGivenDetermineDistanceOfStartingSeries() {
			int[] integerArray = {1, 7, 2, 11, 8, 34, 3};
			int counter = MainRunner.firstDistanceChecker(integerArray);
			assertEquals(6, counter);
		}
		
		@Test
		void whenMultipleNumbersAreGivenDetermineDistanceOfSecondSeries() {
			int[] integerArray = {1, 7, 2, 11, 8, 34, 3};
			int counter = MainRunner.secondDistanceChecker(integerArray);
			assertEquals(3, counter);
		}
		
		@Test
		void whenMultipleNumbersAreGivenDetermineDistanceOfThirdSeries() {
			int[] integerArray = {0, 7, 2, 11, 8, 34, 3};
			int counter = MainRunner.thirdDistanceChecker(integerArray);
			assertEquals(4, counter);
		}
		
		@Test
		void whenAnyTwoNumbersAreGivenDetermineDistance() {
			int[] integerArray = {1, 2};
			int counter = MainRunner.methodExtractedDistanceCalculator(integerArray);
			assertEquals(1, counter);
		}
		
		@Test
		void whenAnyThreeNumbersAreGivenDetermineDistance() {
			int[] integerArray = {3, 1, 5};
			int counter = MainRunner.methodExtractedDistanceCalculator(integerArray);
			assertEquals(0, counter);
		}
		
		@Test
		void whenAnyFourNumbersAreGivenDetermineDistanceOfThirdSeries() {
			int[] integerArray = {3, 1, 4, 2};
			int counter = MainRunner.methodExtractedDistanceCalculator(integerArray);
			assertEquals(4, counter);
		}
		
		@Test
		void distanceForMultipleElementsInSeries() {
//			int[] integerArray = {3, 1, 4, 2, 0};
			int[] integerArray = {1, 7, 2, 11, 8, 34, 3};
			assertEquals(9, MainRunner.iteratingListDistanceCalculator(integerArray));
		}
		
		@Test
		void forwardSeriesObjectifiedDistanceCalculator() {
//			int[] integerArray = {3, 1, 4, 2, 0};
			int[] integerArray = {1, 7, 2, 11, 8, 34, 3};
			
			mainRunner.setIntegerArray(integerArray);
			mainRunner.forwardObjectDistanceCalculator();
			assertEquals(9, mainRunner.getResult());
		}
		
	}
	
	@Nested
	class ReverseDistanceTests {
		@Test
		void determineWhetherSeriesIsPositive() {
			int[] integerArray = {0, 2, 1, 9};
			assertEquals(false, MainRunner.positiveOrNegativeSeries(integerArray, 2));
		}
		
		@Test
		void reverseSeriesObjectifiedDistanceCalculator() {
//			int[] integerArray = {3, 1, 4, 2, 0};
//			int[] integerArray = {1, 7, 2, 11, 8, 34, 3};
			int[] integerArray = {3, 34, 8, 11, 2, 7, 1};
			mainRunner.setIntegerArray(integerArray);
			mainRunner.reverseObjectDistanceCalculator();
			assertEquals(9, mainRunner.getResult());
		}
		
	}
	
	@Nested
	class ForwardAndReverseDistanceTests {
		@Test
		void oneRowDistanceCalculator() {
			int[] integerArray = {1, 7, 2, 11, 8, 34, 3};
			mainRunner.setIntegerArray(forwardAndBackwardIntArray);
			mainRunner.singleRowDistanceCalculator();
			assertEquals(26, mainRunner.getResult());
		}
	}
	
	
}
