package tw.brad.myjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad52 {
	public static void main(String[] args) {
		String source = "dir1/file1.txt";
		String target = "dir2/file3.txt";
		long start = System.currentTimeMillis();
		try {
			FileOutputStream fout = new FileOutputStream(target);
			
			FileInputStream fin = new FileInputStream(source);
			int c;
			while ( (c = fin.read()) != -1) {
				fout.write(c);
			}
			fin.close();
			
			fout.flush();
			fout.close();
			
			System.out.println("Save as ... OK:" + (System.currentTimeMillis()- start));
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
