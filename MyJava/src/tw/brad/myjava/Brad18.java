package tw.brad.myjava;

public class Brad18 {

	public static void main(String[] args) {
		// 陣列 Array
		int b;
		b = 3;
		int[] a;
		a = new int[3];
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		//System.out.println(a[300000]);
		System.out.println("----");
		for (int i=0; i< a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("----");
		a[2] = 123; a[1] = 777;
		for (int i=0; i< a.length; i++) {
			System.out.println(a[i]);
		}
		
		
	}

}
