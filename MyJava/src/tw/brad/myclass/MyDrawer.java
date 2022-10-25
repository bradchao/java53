package tw.brad.myclass;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyDrawer extends JPanel {
	//private LinkedList<LinkedList<HashMap<String, Integer>>> lines; // Lines<Line<Point>>
	//private LinkedList<LinkedList<Point>> lines, recyler; // Lines<Line<Point>>
	private LinkedList<Line> lines, recyler; // Lines<Line<Point>>
	
	private Color nowColor;
	
	public MyDrawer() {
		this(Color.BLUE);
	}
	
	public MyDrawer(Color initColor) {
		setBackground(Color.YELLOW);
		
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
		addMouseMotionListener(myListener);
		
		lines = new LinkedList<>();
		recyler = new LinkedList<>();
		
		nowColor = initColor;
		
	}
	
	public Color getNowColor() {
		return nowColor;
	}
	public void setNowColor(Color color) {
		nowColor = color;
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
	
	public boolean saveJpeg(File saveFile) {
		boolean ret = true;
		BufferedImage img = 
			new BufferedImage(getWidth(), getHeight(), 
				BufferedImage.TYPE_INT_RGB);
		//Graphics2D g = img.createGraphics();
		Graphics g = img.getGraphics();
		paint(g);
		g.dispose();
		
		try {
			ImageIO.write(img, "jpg", saveFile);
		}catch(Exception e) {
			ret = false;
		}
		return ret;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setStroke(new BasicStroke(4));
		
//		for (LinkedList<HashMap<String, Integer>> line : lines ) {
//			for (int i=1; i<line.size(); i++) {
//				HashMap<String, Integer> p0 =  line.get(i-1);
//				HashMap<String, Integer> p1 =  line.get(i);
//				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
//			}
//		}

		//-----------------
		
		for (Line line : lines ) {
			g2d.setColor(line.getColor());
			LinkedList<Point> points = line.getPoints();
			for (int i=1; i<points.size(); i++) {
				Point p0 =  points.get(i-1);
				Point p1 =  points.get(i);
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
			Line line = new Line();
			line.setColor(nowColor);
			line.addPoint(point);
			
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
			lines.getLast().addPoint(point);
			
			repaint();
		}
	}
}

class Point implements Serializable{
	public int x, y;
}
class Line implements Serializable{
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
	void setColor(Color color) {
		this.color = color;
	}
	Color getColor() {
		return color;
	}
}





