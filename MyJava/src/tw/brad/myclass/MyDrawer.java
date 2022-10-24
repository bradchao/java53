package tw.brad.myclass;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrawer extends JPanel {
	private LinkedList<HashMap<String, Integer>> line; // Line<Point>
	
	public MyDrawer() {
		setBackground(Color.YELLOW);
		
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
		
		line = new LinkedList<>();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(4));
		
		for (int i=1; i<line.size(); i++) {
			HashMap<String, Integer> p0 =  line.get(i-1);
			HashMap<String, Integer> p1 =  line.get(i);
			g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
		}
		
	}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX()); point.put("y", e.getY());
			line.add(point);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<>();
			point.put("x", e.getX()); point.put("y", e.getY());
			line.add(point);
			
			repaint();
		}
	}
	
	
}
