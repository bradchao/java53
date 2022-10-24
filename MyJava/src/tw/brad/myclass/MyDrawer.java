package tw.brad.myclass;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrawer extends JPanel {
	//private LinkedList<LinkedList<HashMap<String, Integer>>> lines; // Lines<Line<Point>>
	private LinkedList<LinkedList<Point>> lines, recyler; // Lines<Line<Point>>
	
	public MyDrawer() {
		setBackground(Color.YELLOW);
		
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
		
		lines = new LinkedList<>();
		recyler = new LinkedList<>();
	}
	
	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() {
		recyler.add(lines.removeLast());
		repaint();
	}
	
	public void redo() {
		lines.add(recyler.removeLast());
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(4));
		
//		for (LinkedList<HashMap<String, Integer>> line : lines ) {
//			for (int i=1; i<line.size(); i++) {
//				HashMap<String, Integer> p0 =  line.get(i-1);
//				HashMap<String, Integer> p1 =  line.get(i);
//				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
//			}
//		}

		//-----------------
		
		for (LinkedList<Point> line : lines ) {
			
			for (int i=1; i<line.size(); i++) {
				Point p0 =  line.get(i-1);
				Point p1 =  line.get(i);
				g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
			}
		}
		
	}
	
	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			
//			HashMap<String, Integer> point = new HashMap<>();
//			point.put("x", e.getX()); point.put("y", e.getY());
//			
//			LinkedList<HashMap<String, Integer>> line = new LinkedList<>();
//			line.add(point);
//			
//			lines.add(line);
			
			//-------------------------
			
			Point point = new Point();
			point.x = e.getX(); point.y = e.getY();
			LinkedList<Point> line = new LinkedList<>();
			line.add(point);
			
			lines.add(line);
			
			recyler.clear();
			
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
//			HashMap<String, Integer> point = new HashMap<>();
//			point.put("x", e.getX()); point.put("y", e.getY());
//			
//			lines.getLast().add(point);
			
			//--------------------
			Point point = new Point();
			point.x = e.getX(); point.y = e.getY();
			lines.getLast().add(point);
			
			repaint();
		}
	}
}

class Point {
	public int x, y;
}
class Line {
	private LinkedList<Point> points;
	private Color color;
	private int Width;
	
	Line(){
		points = new LinkedList<>();
	}
	void addPoint(Point point) {
		points.add(point);
	}
	LinkedList<Point> getPoints(){
		return points;
	}
}





