package tw.brad.myjava;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.brad.myclass.MyPanel;

public class MyBallsV2 extends JFrame {
	private MyPanel myPanel;
	
	public MyBallsV2() {
		super("My Game");
	
		setLayout(new BorderLayout());
		myPanel = new MyPanel();
		add(myPanel, BorderLayout.CENTER);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyBallsV2();
	}

}
