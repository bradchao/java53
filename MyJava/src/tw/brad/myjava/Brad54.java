package tw.brad.myjava;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Brad54 {

	public static void main(String[] args) {
		try (FileReader reader = new FileReader("dir1/file1.txt")) {
			int c;
			while ( (c = reader.read()) != -1){
				System.out.print((char)c);
			}
		} catch (Exception e) {
		}
	}

}
