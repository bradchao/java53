package tw.brad.myjava;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame {
	private JButton go;
	private JLabel[] lanes;
	private Car[] cars;
	
	public Racing() {
		super("賽車");
		setLayout(new GridLayout(9, 1));
		
		go = new JButton("Go!"); add(go);
		lanes = new JLabel[8];
		for (int i=0; i<lanes.length; i++) {
			lanes[i] = new JLabel((i+1) + ". ");
			add(lanes[i]);
		}
		
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		preGo();
	}
	
	private void preGo() {
		cars = new Car[8];
		for (int i=0; i<cars.length; i++) {
			cars[i] = new Car(i);
		}
	}
	
	private void go() {
		for (int i=0; i<cars.length; i++) {
			cars[i].start();
		}
	}
	
	private class Car extends Thread {
		private int lane;
		Car (int lane){this.lane = lane;}
		@Override
		public void run() {
			for (int i=0; i<100; i++) {
				lanes[lane].setText(lanes[lane].getText() + ">");
			}
		}
	}

	public static void main(String[] args) {
		new Racing();
	}

}
