package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

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
	// brad@brad.tw
	private class MyPanel extends JPanel {
		private int ballX, ballY, dx, dy;
		private BufferedImage ballImg;
		private Timer timer;
		
		public MyPanel() {
			setBackground(Color.YELLOW);
			
			try {
				ballImg = ImageIO.read(new File("dir1/ball0.png"));
			}catch (Exception e) {
				
			}
			
			dx = dy = 4;
			ballX = ballY = 10;
			
			timer = new Timer();
			timer.schedule(new Task(), 1*1000, 30);
			
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					clickEvent(e.getX(), e.getY());
				}
			});
		}
		
		private void clickEvent(int clickX, int clickY) {
			ballX = clickX - 32; ballY = clickY - 32;
			repaint();
		}
		
		private class Task extends TimerTask {
			@Override
			public void run() {
				if (ballX  <= 0 || ballX + 64 >= getWidth()) {
					dx *= -1;
				}
				if (ballY <= 0 || ballY + 64 >= getHeight()) {
					dy *= -1;
				}
				ballX += dx;
				ballY += dy;
				repaint();
			}
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			
			g.drawImage(ballImg, ballX, ballY, null);
			
		}
	}
	

	public static void main(String[] args) {
		new MyBalls();
	}

}
