package application.calculator;

public class ProcessDate {
	
	//Initializing vars and result variable
	private int result = 0;
	private int yearEntered;
	private int monthEntered;
	private int dateEntered;
	private String dayOfTheWeek;
	private int yearRemaining;
	
	//Enums for the days in forward and backward fashion
	private static final String[] DAYS_OF_THE_WEEK = {"SATURDAY", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY",
													  "THURSDAY", "FRIDAY"};
	private static final String[] DAYS_OF_THE_WEEK_REVERSED = {"SATURDAY", "FRIDAY", "THURSDAY", "WEDNESDAY", "TUESDAY",
															   "MONDAY", "SUNDAY"};
	
	//Reference date to calc from. Might make this a final int.
	enum DateReference {
		YEAR2017(2017), NOVEMBER(11), FOUR(04);
		int value = 0;
		
		DateReference(int value) {
			this.value = value;
		}
	}
	
	//Constructor that initialized variables and calls the calculating days
	public ProcessDate(int[] dateArray) {
		this.yearEntered = dateArray[0];
		this.monthEntered = dateArray[1];
		this.dateEntered = dateArray[2];
		this.calculateDateDifferences();
		this.findDayOfWeek();
	}
	
	
	//Begins the processing and calls methods to calculate the diffs in years months and days
	private void calculateDateDifferences() {
		
		//If the year entered is before 2017 or a year after 2017, call year calculation method or just call the month.
		// The reverse year calculations are working WITHOUT this call! Re-factoring potential!
		if ((yearEntered - DateReference.YEAR2017.value == 1 && monthEntered >= DateReference.NOVEMBER.value) ||
			yearEntered > DateReference.YEAR2017.value + 2) {
			
			this.calculateYear();
		}
		System.out.println(this.result);
		this.calculateMonth();
		System.out.println(this.result);
		this.calculateDay();
		System.out.println(this.result);
		
	}
	
	//Calculate the difference between years in days
	private void calculateYear() {
		int yearTemp = yearEntered;
		//If the year entered is less than 2017, do the negative calculations, or do the positive ones
		if (yearTemp < DateReference.YEAR2017.value) {
			//While the current year is less than 2016 add days
			while (yearTemp != DateReference.YEAR2017.value - 1) {
				if (isLeapYear(yearTemp)) {
					result -= 366;
				} else {
					result -= 365;
				}
				yearTemp++;
			}
		} else {
			//While the current year is greater than 2018 add days
			while (yearTemp != DateReference.YEAR2017.value + 1) {
				if (isLeapYear(yearTemp)) {
					result += 366;
				} else {
					result += 365;
				}
				yearTemp--;
			}
		}
		
		yearRemaining = yearTemp;
		System.out.println("yearRemaining " + yearRemaining);
	}
	
	//Calculate the same between months
	private void calculateMonth() {
		int monthTemp = DateReference.NOVEMBER.value;
		int yearTemp = DateReference.YEAR2017.value;
		if (yearRemaining == 0) {
			yearRemaining = 2017 - (2017 - yearEntered);
		}
		//While the year is 2018 or 2016 AND the current month is not november, cycle through the months until the month is november and the year is 2017
		while (monthTemp != monthEntered || yearRemaining != yearTemp) {
			// This code is working WITHOUT Year calculations. Refactoring potential!
			if (yearEntered <= DateReference.YEAR2017.value) {
				monthTemp--;
				if (monthTemp == 0) {
					monthTemp = 12;
					yearTemp--;
				}
				if (monthTemp == 1 || monthTemp == 3 || monthTemp == 5 || monthTemp == 7 ||
					monthTemp == 8 || monthTemp == 10 || monthTemp == 12) {
					result -= 31;
				} else if (monthTemp == 4 || monthTemp == 6 || monthTemp == 9 || monthTemp == 11) {
					result -= 30;
				} else if (monthTemp == 2 && isLeapYear(yearTemp)) {
					result -= 29;
				} else if (monthTemp == 2) {
					result -= 28;
				}
				
				System.out.println("After calculations, month: " + monthTemp + " result " + result);
			} else {
				if (monthTemp == 1 || monthTemp == 3 || monthTemp == 5 || monthTemp == 7 ||
					monthTemp == 8 || monthTemp == 10 || monthTemp == 12) {
					result += 31;
				} else if (monthTemp == 4 || monthTemp == 6 || monthTemp == 9 || monthTemp == 11) {
					result += 30;
				} else if (monthTemp == 2) {
					result += 28;
				}
				monthTemp++;
				if (monthTemp == 13) {
					monthTemp = 1;
					yearTemp++;
				}
				System.out.println("After calculations, month: " + monthTemp + " result " + result);
				if (monthTemp == 1 && isLeapYear(yearEntered)) {
					result--; // Leap year pre-jump correction.
				}
				
			}
			
			System.out.println(yearTemp + " " + yearRemaining);
			System.out.println(monthTemp != monthEntered);
			System.out.println(yearRemaining != yearTemp);
		}
		
		
	}
	
	//Calculate the same for days in partial months
	private void calculateDay() {
		if (yearEntered < DateReference.YEAR2017.value) {
			result -= 4 - dateEntered;
		} else {
			result += dateEntered - 4;
			
		}
	}
	
	//Cycle through the days of the week
	private void findDayOfWeek() {
		int dateTemp = result;
		if (dateTemp < 0) {
			dateTemp *= -1;
			while (dateTemp >= 7) {
				dateTemp -= 7;
			}
			dayOfTheWeek = DAYS_OF_THE_WEEK_REVERSED[dateTemp];
			
		} else {
			
			while (dateTemp >= 7) {
				dateTemp -= 7;
			}
			dayOfTheWeek = DAYS_OF_THE_WEEK[dateTemp];
		}
		
		
	}
	
	//Prints out the days of the week
	public void getDayOfTheWeek() {
		System.out.println(this.dayOfTheWeek);
		
	}
	
	//Does a leap year check
	private boolean isLeapYear(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}
	
}
