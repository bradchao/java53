package tw.brad.myjava;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Brad60 {

	public static void main(String[] args) {
		String mesg = "Hello, Brad";
		byte[] mesgData = mesg.getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = 
				new DatagramPacket(mesgData, mesgData.length, 
					InetAddress.getByName("10.0.102.72"), 8888);
			socket.send(packet);
			socket.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
