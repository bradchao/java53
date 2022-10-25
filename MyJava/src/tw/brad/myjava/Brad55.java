package tw.brad.myjava;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Brad55 {

	public static void main(String[] args) {
		try (FileInputStream fin = new FileInputStream("dir1/file1.txt");
				InputStreamReader isr = new InputStreamReader(fin);
				BufferedReader br = new BufferedReader(isr)
				){
			String line; int i = 1;
			while ( (line = br.readLine()) != null) {
				System.out.println(i++ + ":" + line);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("-----");
		try (FileReader reader = new FileReader("dir1/sieve.csv");
				BufferedReader br = new BufferedReader(reader)
				){
			String line; int i = 1;
			br.readLine();
			while ( (line = br.readLine()) != null) {
				String[] data = line.split(",");
				System.out.printf("%s:%s\n", data[1], data[7]);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
