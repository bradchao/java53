package tw.brad.myjava;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MyFoodDB extends JFrame {
	private MyFoodTable foodTable;
	
	public MyFoodDB() {
		super();
		
		setLayout(new BorderLayout());
		
		foodTable = new MyFoodTable();
		add(foodTable, BorderLayout.CENTER);
		
		
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MyFoodDB();
	}

}
