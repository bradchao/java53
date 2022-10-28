package tw.brad.myjava;

public class ATMTest {
	public static void main(String[] args) {

	}
}

class ATM {
	private int money;
	private final int LIMIT = 1000;
	
	void addMoney(int add) {
		if (money + add <= LIMIT) {
			money += add;
			System.out.println("add:" + add + " => " + money);
		}else {
			System.out.println("add: xxx");
		}
	}
	void getMoney(int get, String name) {
		if (money >= get) {
			money -= get;
			System.out.println("get:" + get + " => " + money + " : " + name);
		}else {
			System.out.println("get:xxx => " + name);
		}
	}
}

class Bank extends Thread{
	private ATM atm;
	Bank(ATM atm){this.atm = atm;}
	
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			atm.addMoney(200);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			
		}
	}
	
}

class Person extends Thread {
	private ATM atm;
	private String name;
	Person(ATM atm, String name){this.atm = atm; this.name = name;}
	@Override
	public void run() {
		for (int i=0; i<20; i++) {
			atm.getMoney(10 + (int)(Math.random()*50), name);
			
			try {
				Thread.sleep(100);
			}catch(Exception e) {}
		}
	}
}
