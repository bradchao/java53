package tw.brad.myjava;

public class Brad43 {

	public static void main(String[] args) {
		int a = 10, b = 0;
		int c;
		int[] d = {1,2,3,4};
		try {
			c = a / b;
			System.out.println(c);
			System.out.println(d[4]);
//		} catch(RuntimeException re) {
//			System.out.println("XX3");
		} catch(ArrayIndexOutOfBoundsException ie) {
			System.out.println("XX2");
		} catch (ArithmeticException ae) {
			System.out.println("XX1");
		}
		System.out.println("OK");
		
		
		
	}

}
