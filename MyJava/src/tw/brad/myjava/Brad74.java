package tw.brad.myjava;

public class Brad74 {
	public static void main(String[] args) {
		Brad741 obj1 = new Brad741("A");
		obj1.start();
		try {
			Thread.sleep(1000);
		}catch (Exception e) {}
		
		Brad741 obj2 = new Brad741("B");
		obj2.start();
		
		Brad742 obj3 = new Brad742();
		obj3.start();
		
		System.out.println("OK1");
		
		try {
			obj3.join(2000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("OK2");
		
	}
}
class Brad741 extends Thread {
	private String name;
	Brad741(String name){ this.name = name;}
	@Override
	public void run() {
		try {
			for (int i=0; i<10; i++) {
				System.out.println(name + ":" + i);
				//Thread.sleep(500);
			}
		}catch(Exception e) {
			
		}
	}
}

class Brad742 extends Thread {
	@Override
	public void run() {
		for (int i= 0; i<10000000; i++) {
			if (i % 1000000 == 0) System.out.println("Brad");
		}
	}
}
