package tw.brad.myjava;

import javax.swing.JFrame;

public class MySign extends JFrame {
	public MySign() {
		super("簽名App");
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MySign();
	}

}
