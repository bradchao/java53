package tw.brad.myjava;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Brad62 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket(
				InetAddress.getByName("10.0.102.45"), 3306);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
