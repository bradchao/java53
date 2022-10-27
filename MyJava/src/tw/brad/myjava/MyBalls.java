package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyBalls extends JFrame {
	private MyPanel myPanel;
	
	public MyBalls() {
		super();
		
	
		setLayout(new BorderLayout());
		myPanel = new MyPanel();
		add(myPanel, BorderLayout.CENTER);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class MyPanel extends JPanel {
		public MyPanel() {
			setBackground(Color.YELLOW);
		}
	}
	

	public static void main(String[] args) {
		new MyBalls();
	}

}
