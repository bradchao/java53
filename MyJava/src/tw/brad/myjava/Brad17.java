package tw.brad.myjava;

public class Brad17 {

	public static void main(String[] args) {
		int i = 1;
		for ( printBrad() ; i <= 7; printLine()) {
			System.out.println(i++);
		}
		System.out.println("=> " + i);
	}

	static void printBrad() {
		System.out.println("Brad");
	}
	static void printLine() {
		System.out.println("----------------");
	}
}
