package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class FoodDB {
	private Connection conn;
	private ResultSet rs;
	private String[] fieldNames;
	
	public FoodDB() throws SQLException {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/eeit53", prop);
		
	}
	
	public void queryData(String sql) throws SQLException {
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int colCount = rsmd.getColumnCount();
		fieldNames = new String[colCount];
		for (int i=0; i<colCount; i++) {
			fieldNames[i] = rsmd.getColumnName(i+1);
		}
	}
	
	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		}catch(Exception e) {
			return 0;
		}
	}
	
	public int getCols() {
		return fieldNames.length;
	}
	
	public String[] getHeader() {
		return fieldNames;
	}
	
	
	
	
}
