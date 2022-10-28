package tw.brad.myjava;

public class ATMTestV2 {
	public static void main(String[] args) {
		System.out.println("ATMTest V2");
		ATMV2 atm = new ATMV2();
		BankV2 bank = new BankV2(atm);
		PersonV2 a = new PersonV2(atm, "A");
		PersonV2 b = new PersonV2(atm, "B");
		PersonV2 c = new PersonV2(atm, "C");
		
		bank.start();
		a.start();
		b.start();
		c.start();
		
	}
}

class ATMV2 {
	private int money;
	private final int LIMIT = 1000;
	
	void addMoney(int add) {
		while (money + add > LIMIT) {
			System.out.println("add: xxx....wait");
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		money += add;
		System.out.println("add:" + add + " => " + money);
		notifyAll();
	}
	void getMoney(int get, String name) {
		while (money < get) {
			System.out.println("get:xxx => wait... " + get + " : " + name);
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		money -= get;
		System.out.println("get:" + get + " => " + money + " : " + name);
		notifyAll();
	}
}

class BankV2 extends Thread{
	private ATMV2 atm;
	BankV2(ATMV2 atm){this.atm = atm;}
	
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			
			synchronized (atm) {
				atm.addMoney(200);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			
		}
	}
	
}

class PersonV2 extends Thread {
	private ATMV2 atm;
	private String name;
	PersonV2(ATMV2 atm, String name){this.atm = atm; this.name = name;}
	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			synchronized (atm) {
				atm.getMoney(10 + (int)(Math.random()*50), name);
			}
			
			try {
				Thread.sleep(100);
			}catch(Exception e) {}
		}
		System.out.println(name + ":stop");
	}
}
