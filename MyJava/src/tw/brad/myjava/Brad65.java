package tw.brad.myjava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Brad65 {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket(InetAddress.getByName("10.0.102.45"), 9487);
			OutputStream out = socket.getOutputStream();
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			FileInputStream fin = new FileInputStream("dir1/coffee.jpg");
			BufferedInputStream bin = new BufferedInputStream(fin);
			
			int len; byte[] buf = new byte[16*1024];
			while ( (len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			
			bin.close();
			
			bout.flush();
			bout.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
