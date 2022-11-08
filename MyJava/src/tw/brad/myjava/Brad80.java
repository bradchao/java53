package tw.brad.myjava;

import java.io.Console;

public class Brad80 {

	public static void main(String[] args) {
		Console console = System.console();
		char[] passwd = console.readPassword();
		System.out.println(new String(passwd));
	}

}
