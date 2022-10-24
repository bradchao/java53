package tw.brad.myjava;

import java.io.File;

public class Brad47 {

	public static void main(String[] args) {
		File f1 = new File("d:/test/dir1");
		if (f1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
			f1.mkdir();
		}
		System.out.println("----");
		File dir1 = new File("dir1");
		if (dir1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		
	}

}
