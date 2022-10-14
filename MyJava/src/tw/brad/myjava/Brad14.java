package tw.brad.myjava;

public class Brad14 {

	public static void main(String[] args) {
		int a = 10, b = 3;

//		System.out.println(++a);
//		System.out.println(a);
//		System.out.println(--b);
//		System.out.println(b);
		
		if (++a > 10 || --b < 3) {
			System.out.printf("OK: a = %d, b = %d", a, b);
		}else {
			System.out.printf("XX: a = %d, b = %d", a, b);
		}
		
		
	}

}
