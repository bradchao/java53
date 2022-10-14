package tw.brad.myjava;

public class Brad13 {

	public static void main(String[] args) {
		int year = 2022;
		
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					// OK
				}else {
					// XX
				}
			}else {
				// 潤
			}
		}else {
			// 平
		}
		//------------------------------------
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			// 潤
		}else {
			// 平
		}
		
		
	}

}
