package tw.brad.myjava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad67 {

	public static void main(String[] args) {
		while (true) {
			try {
				ServerSocket server = new ServerSocket(20000);
				Socket socket = server.accept();
				
				String filename = socket.getInetAddress().getHostAddress() + ".jpg";
				
				InputStream in = socket.getInputStream();
				BufferedInputStream bin = new BufferedInputStream(in);
				int len; byte[] buf = new byte[1024*1024*1024];
				len = bin.read(buf);
				
				if (len > 0) {
					FileOutputStream fout = new FileOutputStream("dir3/" + filename);
					BufferedOutputStream bout = new BufferedOutputStream(fout);
					bout.write(buf, 0, len);
					
					bout.flush();
					bout.close();
				}
				
				bin.close();
				
				server.close();
				
				System.out.println("ReceiveV2 Success:" + filename);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		
	}

}
