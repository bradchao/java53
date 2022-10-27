package tw.brad.myclass;

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
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private Timer timer;
	private int viewW, viewH;
	
	public MyPanel() {
		setBackground(Color.YELLOW);
		timer = new Timer();
		timer.schedule(new RefreshTask(), 0, 16);
		
	}
	
	private class RefreshTask extends TimerTask {
		@Override
		public void run() {
			repaint();
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth(); viewH = getHeight();
		
		Graphics2D g2d = (Graphics2D)g;
		
		//g.drawImage(ballImg, ballX, ballY, null);
		
	}
	
}

class Ball extends TimerTask {
	private int x, y, dx, dy;
	private int ball;	// 0, 1, 2
	private MyPanel myPanel;
	
	Ball(int x, int y, MyPanel myPanel){
		this.x = x; this.y = y;
		dx = dy = 4;
		ball = (int)(Math.random()*3);
		this.myPanel = myPanel;
	}
	
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

