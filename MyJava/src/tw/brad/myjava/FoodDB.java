package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FoodDB {
	private Connection conn;
	
	public FoodDB() throws SQLException {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/eeit53", prop);
		
	}
}
