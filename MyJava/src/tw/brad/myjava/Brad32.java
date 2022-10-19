package tw.brad.myjava;

import tw.brad.myclass.Bike;

public class Brad32 {
	public static void main(String[] args) {
		Brad321 obj1 = new Brad321();
		Brad321 obj2 = new Brad321();
		Brad321 obj3 = obj1;
		if (obj1.equals(obj3)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		System.out.println(obj1 == obj2);
		System.out.println(obj1 == obj3);
		System.out.println("---------");
		String s1 = "Brad";
		String s2 = "Brad";
		String s3 = new String("Brad");
		String s4 = new String("Brad");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println("---------");
		System.out.println(s1.equals(s2));
		System.out.println("---------");
		StringBuffer sb1 = new StringBuffer("Brad");
		StringBuffer sb2 = new StringBuffer("Brad");
		System.out.println(sb1 == sb2);
		System.out.println(sb1.equals(sb2));
		System.out.println("---");
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		System.out.println(b1);
		System.out.println(b1.toString());
		System.out.println(sb1);
		
		
		
		
		
		
		
		
		
	}
}

class Brad321 {
	
}
