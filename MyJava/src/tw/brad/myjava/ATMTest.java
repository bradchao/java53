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
		if (money <= get) {
			money -= get;
			System.out.println("get:" + get + " => " + money);
		}else {
			System.out.println("get:xxx => " + name);
		}
	}
	
}
class Bank {
	
}
class Person {
	
}
