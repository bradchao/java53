package tw.brad.myjava;

public class Brad36 {
	public static void main(String[] args) {
		Brad361 obj1 = new Brad362();
		Brad363 obj2 = new Brad362();
		
		Brad361 obj3 = new Brad361() {
			@Override
			public void m1() {
				
			}

			@Override
			public void m2() {
				
			}
		};
	}
}

interface Brad361 {
	void m1();
	void m2();
}
class Brad362 implements Brad361, Brad363 {
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
}
interface Brad363 {
	void m3();
	void m4();
}
interface Brad364 extends Brad361, Brad363 {
	void m5();
}