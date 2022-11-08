package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.myclass.BCrypt;
import tw.brad.myclass.Member;

public class JDBC12 {
	private final static String url = "jdbc:mysql://localhost:3306/eeit53";
	private final static String sql = "SELECT * FROM member WHERE account = ?";
	private final static String sqlUpdate = 
		"UPDATE member SET passwd = ? WHERE id = ?";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Account: ");
		String account = scanner.next();
		
		System.out.print("Password: ");
		String passwd = scanner.next();
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try(Connection conn = DriverManager.getConnection(url, prop);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(passwd, rs.getString("passwd"))) {
					Member member = new Member(rs.getInt("id"), 
							rs.getString("account"), 
							rs.getString("passwd"),
							rs.getString("realname"));
					System.out.printf("Welcome, %s", member.getRealname());
					
					System.out.println("Change Password...");
					
					System.out.print("Old Password: ");
					String oldPasswd = scanner.next();
					// check oldPasswd
					if (BCrypt.checkpw(oldPasswd, member.getPasswd())) {
						System.out.print("New Password: ");
						String newPasswd = scanner.next();
						
						// change newPasswd
						PreparedStatement pstmt2 = conn.prepareStatement(sqlUpdate);
						pstmt2.setString(1, BCrypt.hashpw(newPasswd, BCrypt.gensalt()));
						pstmt2.setInt(2, member.getId());
						if (pstmt2.executeUpdate() != 0 ) {
							System.out.println("Change passwd success");
						}else {
							System.out.println("Change passwd failure");
						}
					}else {
						System.out.println("Passwd not match!");
					}
					
				}else {
					System.out.println("XX");
				}
			}else {
				System.out.println("get out here");
			}
			
			rs.close();
			
		}catch(Exception e) {
			
		}
	}
	
}
