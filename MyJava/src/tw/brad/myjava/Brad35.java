package tw.brad.myjava;

public class Brad35 {

	public static void main(String[] args) {
		Brad351 obj1 = new Brad351() {
			void m2() {}
		};
		
		m1(new Brad351() {
			@Override
			void m2() {
				
			}
		});
	}
	
	static void m1(Brad351 obj) {
		
	}

}
abstract class Brad351{
	void m1() {}
	abstract void m2();
}
