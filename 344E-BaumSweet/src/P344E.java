import java.util.Arrays;


public class P344E {
	private static boolean flag = true;
	
	public static void main(String[] args) {
		int number = 0;
		System.out.print("1");
		while (number <= 20) {
			flag = true;
			Arrays.stream(Integer.toBinaryString(number).split("1")).filter(s -> s.length() % 2 != 0)
				  .forEach(P344E::b_nEqualsZero);
			if (flag) {
				System.out.print(", 1");
			}
			number++;
		}
		
		
	}
	
	private static void b_nEqualsZero(String nonsense) {
		if (flag) {
			System.out.print(", 0");
			flag = false;
		}
	}
}
