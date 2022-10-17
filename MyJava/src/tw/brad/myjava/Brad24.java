package tw.brad.myjava;

import java.util.Scanner;

public class Brad24 {

	public static void main(String[] args) {
		// 1 + 2 + 3 + ... + n = ?
		int i = 1;
		int sum = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("n = ");
		int n = scanner.nextInt();
		
//		while (i <= n) {
//			sum += i++;	// 1, 2
//		}
		
		for (;i <= n;) {
			sum += i++;	// 1, 2
		}
		
		
		System.out.printf("1 + 2 + ... + %d = %d", n, sum);
	}

}
