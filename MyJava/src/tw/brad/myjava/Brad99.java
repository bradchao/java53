package tw.brad.myjava;

public class Brad99 {

	public static void main(String[] args) {
		for (int j = 1; j<=9; j++) {
			for (int i=2; i<6; i++) {
				int r = i * j;
				System.out.printf("%d x %d = %d\t", i, j, r);
			}
			System.out.println();
		}
	}

}