package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC02 {
	public static void main(String[] args) {
		try {
//			Connection conn = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306/eeit53?user=root&password=root");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/eeit53",
					"root", "root");
			
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
