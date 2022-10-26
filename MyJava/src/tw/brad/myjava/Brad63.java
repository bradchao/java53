package tw.brad.myjava;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad63 {

	public static void main(String[] args) {

		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("Listen...");
			Socket socket = server.accept();
			
			InputStream in = socket.getInputStream();
			int c;
			while ( (c = in.read()) != -1) {
				System.out.print((char)c);
			}
			in.close();
			
			server.close();
			
			String ip = socket.getInetAddress().getHostAddress();
			System.out.println("\nServer OK:" + ip);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}

}
