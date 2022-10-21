package tw.brad.myclass;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrawer extends JPanel {
	private LinkedList<HashMap<String, Integer>> line; 
	
	public MyDrawer() {
		setBackground(Color.YELLOW);
		
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
				
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(4));
		
		g2d.drawLine(0, 0, 200, 100);
		
	}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("Press:" + e.getX() + " x " + e.getY());
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			System.out.println("Drag:" + e.getX() + " x " + e.getY());
		}
	}
	
	
}
