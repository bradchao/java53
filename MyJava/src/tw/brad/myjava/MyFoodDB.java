package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MyFoodDB extends JFrame {
	private MyFoodTable foodTable;
	private JButton del, add;
	
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
		
		JPanel top = new JPanel(new FlowLayout());
		del = new JButton("Del"); add = new JButton("Add");
		top.add(del); top.add(add);
		
		add(top, BorderLayout.NORTH);
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setListener();
	}
	
	private void setListener() {
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				foodTable.delRow();
			}
		});
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				foodTable.addRow();
			}
		});
	}

	public static void main(String[] args) {
		new MyFoodDB();
	}

}
