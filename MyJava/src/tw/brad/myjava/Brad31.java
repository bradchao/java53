package tw.brad.myjava;

import tw.brad.myclass.TWId;

public class Brad31 {

	public static void main(String[] args) {
		
		TWId id1 = new TWId();
		System.out.printf("ID1: %s \n", id1.getId());
		
		TWId id2 = new TWId(false);
		System.out.printf("ID2: %s \n", id2.getId());
		
		TWId id3 = new TWId(4);
		System.out.printf("ID3: %s \n", id3.getId());
		
		TWId id4 = new TWId(true, 7);
		System.out.printf("ID4: %s \n", id4.getId());
		
		
	}

}
