package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC17 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		String sql = "SELECT * FROM food";
		try {
			Connection conn = 
				DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/eeit53", prop);
			
			PreparedStatement pstmt = conn.prepareStatement(sql, 
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_UPDATABLE);
			
//			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
			System.out.println("---");

			rs.first();
			String name = rs.getString("name");
			System.out.println(name);
			System.out.println("---");

//			rs.absolute(5);
//			name = rs.getString("name");
//			System.out.println(name);
//			rs.deleteRow();
			
			rs.absolute(1);
			name = rs.getString("name");
			System.out.println(name);
			
			rs.updateString("name", "Brad大酒店");
			rs.updateString("tel", "7777");
			rs.updateRow();
			
			System.out.println("---");
			
			rs.moveToInsertRow();
			rs.updateString("name", "Brad大酒店V2");
			rs.updateString("tel", "9999");
			rs.updateString("addr", "");
			rs.updateString("city", "");
			rs.updateString("town", "");
			rs.updateString("picurl", "");
			rs.updateDouble("lat", 0);
			rs.updateDouble("lng",0);
			rs.insertRow();
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
