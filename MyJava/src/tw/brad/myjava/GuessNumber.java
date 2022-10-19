package tw.brad.myjava;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame implements ActionListener{
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	private String answer;
	
	public GuessNumber() {
		super("猜數字遊戲");
		
		guess = new JButton("猜");
		input = new JTextField(); log = new JTextArea();
		
		setLayout(new BorderLayout());
		
		JPanel top = new JPanel(new BorderLayout());
		top.add(input, BorderLayout.CENTER);
		top.add(guess, BorderLayout.EAST);
		
		add(top, BorderLayout.NORTH);
		add(log, BorderLayout.CENTER);
		
		guess.addActionListener(this);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		newRound();
	}
	
	private String createAnswer(int dig) {
		int nums = 10;
		int[] poker = new int[nums];
		for (int i=0; i<nums; i++) poker[i] = i;
		for (int i = nums -1; i > 0; i--) {
			int rand = (int)(Math.random() * (i+1));
			// poker[rand] <-> poker[i]
			int temp = poker[rand];
			poker[rand] = poker[i];
			poker[i] = temp;
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<dig; i++) {
			sb.append(poker[i]);
		}
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		new GuessNumber();
	}
	
	private void newRound() {
		answer = createAnswer(3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String result = checkAB();
		log.append(input.getText() + ":" + result + "\n");
	}
	
	private String checkAB() {
		int a, b; a = b = 0;
		for (int i=0; i<answer.length(); i++)){
			if (answer中的第i馬 == guess中的第i馬 ) {
				a++;
			}else if (guess中的第i馬 是否存在於 a 中) {
				b++;
			}
		}
		return String.format("%dA%dB",a, b );
	}
	

}
