package tw.brad.myclass;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private Timer timer;
	private int viewW, viewH;
	private LinkedList<Ball> balls;
	private BufferedImage[] ballImgs;
	
	public MyPanel() {
		setBackground(Color.YELLOW);
		
		ballImgs = new BufferedImage[3];
		try {
			ballImgs[0] = ImageIO.read(new File("dir1/ball0.png"));
			ballImgs[1] = ImageIO.read(new File("dir1/ball1.png"));
			ballImgs[2] = ImageIO.read(new File("dir1/ball2.png"));
		}catch (Exception e) {
		}
		
		timer = new Timer();
		timer.schedule(new RefreshTask(), 0, 16);
		
		balls = new LinkedList<>();
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickEvent(e.getX(), e.getY());
			}
		});

		
	}
	
	private class RefreshTask extends TimerTask {
		@Override
		public void run() {
			repaint();
		}
	}
	
	private void clickEvent(int clickX, int clickY) {
		// 產生新的 ball
		Ball ball = new Ball(clickX - 32, clickY -32, this);
		
		// 放在 balls
		balls.add(ball);
		
		// 並且 排程
		timer.schedule(ball, 500, 30);
	}	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth(); viewH = getHeight();
		
		Graphics2D g2d = (Graphics2D)g;
		
		for (Ball ball: balls) {
			g.drawImage(ballImgs[ball.getBall()], ball.getX(), ball.getY(), null);
		}
		
	}
	
}

class Ball extends TimerTask {
	private int x, y, dx, dy;
	private int ball;	// 0, 1, 2
	private JPanel myPanel;
	
	Ball(int x, int y, JPanel myPanel){
		this.x = x; this.y = y;
		dx = dy = 4;
		ball = (int)(Math.random()*3);
		this.myPanel = myPanel;
	}
	
	public int getX() {return x;}
	public int getY() {return y;}
	public int getBall() {return ball;}
	
	@Override
	public void run() {
		if (x  <= 0 || x + 64 >= myPanel.getWidth()) {
			dx *= -1;
		}
		if (y <= 0 || y + 64 >= myPanel.getHeight()) {
			dy *= -1;
		}
		x += dx;
		y += dy;	
	}
}

