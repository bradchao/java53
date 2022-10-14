package tw.brad.myjava;

public class Brad10 {

	public static void main(String[] args) {
		// Score => 0 - 100 (int)
		/*
		double score = Math.random();	// 0.0 <= score < 1.0
		double score2 = score * 101;	// 0.0 <= score2 < 101.0
		int score3 = (int)score2;	// 0 <= score3 <= 100
		*/
		
		int score = (int)(Math.random()*101);
		System.out.println(score);
		
		// Pass / Down
		if (score >= 60) {
			System.out.println("Pass");
		}else {
			System.out.println("Down");
		}
		
		
		
	}

}
