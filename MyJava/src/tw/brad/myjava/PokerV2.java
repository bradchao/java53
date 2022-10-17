package tw.brad.myjava;

import java.util.Arrays;

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
			//System.out.println(poker[i]);
		}
		System.out.println("---");
		System.out.println(System.currentTimeMillis() - start);
		System.out.println("---");
		
		int[][] players = new int[4][13];
		for (int i=0; i<poker.length; i++) {
			players[i % 4][i / 4] = poker[i];
		}
		// A,2,3...J,Q,K,A,2,3......JQK
		// 0,1,2,3...12, 13,14,15,...25,26,27, ....
		// 黑桃          紅心           方塊          梅花 
		String[] symbols = new String[] {"黑桃","紅心","方塊","梅花"};
		String[] values = {"A ","2 ","3 ","4 ","5 ","6 ","7 ",
				"8 ","9 ","10","J ","Q ","K ",};
		
		for (int[] cards : players) {
			Arrays.sort(cards);
			for (int card: cards) {
				System.out.print(symbols[card / 13] + values[card % 13] + " ");
			}
			System.out.println();
		}
		
	}

}
