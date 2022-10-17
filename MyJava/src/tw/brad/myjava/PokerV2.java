package tw.brad.myjava;

public class PokerV2 {

	public static void main(String[] args) {
		int[] poker = new int[52];	// 0 - 51 => 0
		
		long start = System.currentTimeMillis();
		boolean isDup; int rand;
		for (int i=0; i<poker.length; i++) {
			do {
				rand = (int)(Math.random()*52);	// 0 - 51
	
				// 檢查機制
				isDup = false;
				for (int j=0; j < i; j++) {
					if (poker[j] == rand) {
						// 重複了
						isDup = true;
						break;
					}
				}
			}while (isDup);

			poker[i] = rand;
			System.out.println(poker[i]);
		}
		System.out.println("---");
		System.out.println(System.currentTimeMillis() - start);
		
	}

}
