package tw.brad.myjava;

import tw.brad.myclass.BCrypt;

public class Brad79 {

	public static void main(String[] args) {
		String hash = "$2a$10$lnNLM34qd00ddJ37oCYK2ekqq8tFoHNrZySJxc2K5BjV0R0Mip6ei";
		String passwd = "1234567";
		if (BCrypt.checkpw(passwd, hash)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		
	
	}

}
