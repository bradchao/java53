package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JDBC11 {
	private static Connection conn;
	private final static String url = "jdbc:mysql://localhost:3306/eeit53";
	private final static String sqlCheck = "SELECT count(*) FROM member WHERE account = ?";
	private static final String sqlInsert = "INSERT INTO member (account,passwd,realname) VALUES (?,?,?)";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Account: ");
		String account = scanner.next();
		
		System.out.print("Password: ");
		String passwd = scanner.next();
		
		System.out.print("Realname: ");
		String realname = scanner.next();
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		try {
			conn = DriverManager.getConnection(url, prop);
			if (checkAccount(account)) {
				if (addData(account,passwd,realname)) {
					System.out.println("OK");
				}else {
					System.out.println("Insert XX");
				}
			}else {
				System.out.println("Account XX");
			}
			conn.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	
	static boolean checkAccount(String account) {
		
		return true;
	}
	
	static boolean addData(String account, String passwd, String realname) {
		
		return true;
	}
	
}
