package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC09 {
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
		
		String url = "jdbc:mysql://localhost:3306/eeit53";
		String sql = "INSERT INTO member (account,passwd,realname) VALUES (?,?,?)";
		try(Connection conn = DriverManager.getConnection(url, prop);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, account);
			pstmt.setString(2, passwd);
			pstmt.setString(3, realname);
			int n = pstmt.executeUpdate();
			
			if (n > 0) {
				System.out.println("Register Success!");
			}else {
				System.out.println("Register Failure!");
			}
			
		}catch(Exception e) {
			
		}
		

	}
}
