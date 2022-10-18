package tw.brad.myjava;

public class Brad30 {

	public static void main(String[] args) {
		String s1 = "Brad";
		String s2 = new String();
		byte[] b1 = {97, 98, 99, 100, 101, 102};
		String s3 = new String(b1);
		System.out.println(s3);
		String s4 = new String(b1, 2, 4);
		System.out.println(s4);
		
		String s5 = s4.concat("ghijk");
		System.out.println(s4);
		System.out.println(s5);
		
		
	}

}
