package tw.brad.myclass;

public class TWId {

	public static boolean isValidTWId(String id) {
		boolean ret = false;
		
		if (id.matches("[A-Z][1289][0-9]{8}")) {
			ret = true;
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
