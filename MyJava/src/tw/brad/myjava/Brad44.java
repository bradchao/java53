package tw.brad.myjava;

public class Brad44 {
	public static void main(String[] args) {
		Bird b1 = new Bird();
		try {
			b1.setLeg(3);
		}catch (Exception e) {
			System.out.println("XXX");
		}
		System.out.println(b1.leg);
	}
}

class Bird {
	int leg;
	void setLeg(int n) throws Exception {
		if (n >= 0 && n <= 2) {
			leg = n;
		}else {
			throw new Exception();
		}
	}
}
