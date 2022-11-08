package tw.brad.myjava;

import tw.brad.myclass.BCrypt;

public class Brad78 {

	public static void main(String[] args) {
		String passwd = "123456";
		String passwdHash = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(passwdHash);
		System.out.println(passwdHash.length());
	}

}
