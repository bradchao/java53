package tw.brad.myjava;

public class Brad15 {

	public static void main(String[] args) {
		int a = 10;
		final int b = 3;
		
		switch (a) {	// byte, short, int, char, String, enum
			case b:
				System.out.println("A");
				break;
			case 10:
				System.out.println("B");
				//break;
			default:
				System.out.println("X");
				//break;
			case 1000:
				System.out.println("C");
				//break;
		}
		System.out.println("End");
	}

}
