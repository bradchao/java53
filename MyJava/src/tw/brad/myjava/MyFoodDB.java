package tw.brad.myjava;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class MyFoodDB extends JFrame {
	private MyFoodTable foodTable;
	
	public MyFoodDB() {
		super();
		
		setLayout(new BorderLayout());
		
		try {
			foodTable = new MyFoodTable();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JScrollPane jsp = new JScrollPane(foodTable);
		add(jsp, BorderLayout.CENTER);
		
		
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyFoodDB();
	}

}
