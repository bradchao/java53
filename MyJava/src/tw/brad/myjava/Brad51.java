package tw.brad.myjava;

import java.io.FileOutputStream;

public class Brad51 {

	public static void main(String[] args) {
		String data = "Brad\n";
		try {
			FileOutputStream fout = 
					new FileOutputStream("dir1/file2.txt", true);
			fout.write(data.getBytes());
			fout.flush();
			fout.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

}
