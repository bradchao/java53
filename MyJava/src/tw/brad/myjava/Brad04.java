package tw.brad.myjava;

import java.util.Scanner;

public class Brad04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("X = ");
		int v1 = scanner.nextInt();
		System.out.print("Y = ");
		int v2 = scanner.nextInt();
		
		int result1 = v1 + v2;
		int result2 = v1 - v2;
		int result3 = v1 * v2;
		int result4 = v1 / v2;
		int result5 = v1 % v2;
		
		System.out.printf("%d + %d = %d\n", v1, v2, result1);
		System.out.printf("%d - %d = %d\n", v1, v2, result2);
		System.out.printf("%d x %d = %d\n", v1, v2, result3);
		System.out.printf("%d / %d = %d\n", v1, v2, result4);
		System.out.printf("%d %% %d = %d\n", v1, v2, result5);
		
	}

}
