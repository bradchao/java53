package tw.brad.myjava;

public class PokerV1 {

	public static void main(String[] args) {
		int[] poker = new int[52];	// 0 - 51 => 0
		
		long start = System.currentTimeMillis();
		
		for (int i=0; i<poker.length; i++) {
			int rand = (int)(Math.random()*52);	// 0 - 51

			// 檢查機制
			boolean isDup = false;
			for (int j=0; j < i; j++) {
				if (poker[j] == rand) {
					// 重複了
					isDup = true;
					break;
				}
			}

			if (!isDup) {
				poker[i] = rand;
				System.out.println(poker[i]);
			}else {
				i--;
			}
		}
		System.out.println("---");
		System.out.println(System.currentTimeMillis() - start);
		
	}

}
