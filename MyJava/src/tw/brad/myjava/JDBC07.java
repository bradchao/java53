package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class JDBC07 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Keyword =  ");
		String key = scanner.next();
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Connection conn = 
					DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/eeit53", prop);
			String sql = "SELECT * FROM food WHERE name LIKE ? OR addr LIKE ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + key + "%");
			pstmt.setString(2, "%" + key + "%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				System.out.printf("%s : %s\n", name, addr);
			}

			rs.close();
			
			conn.close();
		} catch (Exception e) {
			
		}

	}

}
