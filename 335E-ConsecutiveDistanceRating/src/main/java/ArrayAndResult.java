class ArrayAndResult {
	private int[] integerArray;
	private int result = 0;
	
	int getResult() {
		return result;
	}
	
	void setResult(int result) {
		this.result += result;
	}
	
	int[] getIntegerArray() {
		return integerArray;
	}
	
	void setIntegerArray(int[] integerArray) {
		this.integerArray = integerArray;
	}
}
