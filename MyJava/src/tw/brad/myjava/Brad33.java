package tw.brad.myjava;

public class Brad33 {
	public static void main(String[] args) {
		Brad331 obj1 = new Brad331();
		Brad331 obj2 = new Brad332();
		Brad331 obj3 = new Brad333();
		obj1.m1();
		obj2.m1();
		obj3.m1();
		Brad333 obj4 = (Brad333)obj3;
		obj4.m2();
		//Brad333 obj5 = (Brad333)obj1;
		//Brad333 obj6 = (Brad333)obj2; 
		Brad332 obj7 = new Brad332();
		//Brad333 obj8 = (Brad333)obj7;
		Brad333 obj9 = new Brad333();
		System.out.println("-----");
		
		go(obj1);
		go(obj7);
		go(obj9);
		
	}
	
	static void go(Brad331 car) {
		car.m1();
		if (car instanceof Brad333) {
			((Brad333) car).m2();
		}
	}
	
	
}
class Brad331 {
	void m1() {
		System.out.println("Brad331:m1()");
	}
}
class Brad332 extends Brad331 {
	void m1() {
		System.out.println("Brad332:m1()");
	}
}
class Brad333 extends Brad331 {
	void m1() {
		System.out.println("Brad333:m1()");
	}
	void m2() {
		System.out.println("Brad333:m2()");
	}
}
