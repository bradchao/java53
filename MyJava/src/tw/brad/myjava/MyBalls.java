package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyBalls extends JFrame {
	private MyPanel myPanel;
	
	public MyBalls() {
		super("My Game");
	
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
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					clickEvent(e.getX(), e.getY());
				}
			});
		}
		
		private void clickEvent(int x, int y) {
			
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			
			try {
				BufferedImage img = ImageIO.read(new File("dir1/ball0.png"));
				g.drawImage(img, 0, 0, null);
			}catch (Exception e) {}
			
			
		}
	}
	

	public static void main(String[] args) {
		new MyBalls();
	}

}
