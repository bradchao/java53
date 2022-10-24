package tw.brad.myjava;

import java.io.File;
import java.io.FileInputStream;

public class Brad50 {
	public static void main(String[] args) {
		FileInputStream fin = null;
		try {
			File file = new File("dir1/file1.txt");
			fin = new FileInputStream(file);
			byte[] buf = new byte[(int)file.length()];
			fin.read(buf);
			System.out.println(new String(buf));
					
			fin.close();
			System.out.println("OK");
		}catch(Exception fe) {
			System.out.println("XX");
//		}catch(FileNotFoundException fe) {
//			System.out.println("XX2");
//		}catch(IOException fe) {
//			System.out.println("XX1");
		}
	}
}
