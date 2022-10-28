package tw.brad.myjava;

public class Brad75 {
	public static void main(String[] args) {
		Brad741 objA = new Brad741("A");
		Brad741 objB = new Brad741("B");
		Brad741 objC = new Brad741("C");
		
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		System.out.println(Thread.MAX_PRIORITY);
		
		objA.setPriority(Thread.MIN_PRIORITY);
		objB.setPriority(Thread.NORM_PRIORITY);
		objC.setPriority(Thread.MAX_PRIORITY);
		
		//objA.setDaemon(true);
		objA.start();
		objB.start();
		objC.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		
		System.out.println("main");
	}
}
