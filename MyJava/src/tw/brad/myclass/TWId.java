package tw.brad.myclass;

public class TWId {

	public static boolean isValidTWId(String id) {
		boolean ret = false;
		
		if (id.matches("[A-Z][1289][0-9]{8}")) {
			String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
			char c1 = id.charAt(0);
			int pos = letters.indexOf(c1);	// 0 - 25
			int n12 = pos + 10;	// 10 - 35
			int n1 = n12 / 10;
			int n2 = n12 % 10;
			//-----------------------
			String s3 = id.substring(1, 2);
			int n3 = Integer.parseInt(s3);
			
			int n4 = Integer.parseInt(id.substring(2, 3));
			int n5 = Integer.parseInt(id.substring(3, 4));
			int n6 = Integer.parseInt(id.substring(4, 5));
			int n7 = Integer.parseInt(id.substring(5, 6));
			int n8 = Integer.parseInt(id.substring(6, 7));
			int n9 = Integer.parseInt(id.substring(7, 8));
			int n10 = Integer.parseInt(id.substring(8, 9));
			int n11 = Integer.parseInt(id.substring(9, 10));
			//--------------------
			int sum = n1*1 + n2*9 + n3*8 + n4*7 + n5*6 + n6*5 +
					n7*4 + n8*3 + n9*2 + n10*1 + n11*1;
			ret = sum % 10 == 0;
		}
		
//		if (id.length() == 10) {
//			char c1 = id.charAt(0);
////			String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
////			if (letters.indexOf(c1) >= 0) {
////				
////			}
////			if (Character.isLetter(c1)) {
////				String c2nds = "1289";
////				String c2nd = id.substring(1, 2);
////				if (c2nds.contains(c2nd)) {
////				}
////			}
//		}
		
		return ret;
	}
}
