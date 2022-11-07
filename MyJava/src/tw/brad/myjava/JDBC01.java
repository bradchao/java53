package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC01 {
	public static void main(String[] args) {
		// 1. Load Driver
		// ? com.microsoft.sqlserver.jdbc.SQLServerDriver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		// 2. create connection
		// ?sql server: jdbc:sqlserver://localhost;database=eeit53;
		try {
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/eeit53?user=root&password=root");
			
			// 3. SQL statement
			Statement stmt = conn.createStatement();
			stmt.execute(
				"INSERT INTO cust (cname,tel,birthday) VALUES ('tony','111','1999-01-02')");
			
			conn.close();
			System.out.println("OK2");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		
		
		
	}
}
