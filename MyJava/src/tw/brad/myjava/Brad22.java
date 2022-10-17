package tw.brad.myjava;

public class Brad22 {

	public static void main(String[] args) {
		int[][] a = new int[3][];
		a[0] = new int[2];
		a[1] = new int[3];
		a[2] = new int[4];
		
		a[0][1] = 123;
		a[1][2] = 333;
		a[2][1] = 121;
		
		for (int i=0; i<a[2].length; i++) {
			System.out.println(a[2][i]);
		}
		System.out.println("---");
		// for-each
		for (int v : a[2]) {
			System.out.println(v);
		}
		System.out.println("---");
		for(int[] v: a) {
			for (int vv: v) {
				System.out.print(vv + "  ");
			}
			System.out.println();
		}
		
		
		
		
	}

}
