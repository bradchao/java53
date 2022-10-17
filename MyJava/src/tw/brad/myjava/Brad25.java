package tw.brad.myjava;

import tw.brad.myclass.Bike;

public class Brad25 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		System.out.println(b1.speed);
		System.out.println(b2.speed);
		b1.speed = 123;
		b2.speed = 10.2;
		System.out.println(b1.speed);
		System.out.println(b2.speed);
		System.out.println("----");
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1.speed);
		
	}

}
