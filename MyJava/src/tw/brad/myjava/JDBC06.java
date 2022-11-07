package tw.brad.myjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

public class JDBC06 {

	public static void main(String[] args) {
		// URL
		// HttpURLConnection
		// InputStrem => JSON String
		// parse JSON String
		// connction DB => eeit53 => food table
		// PreparedStatement
		
		try {
			String json = getJSONString();
			parseJSON(json);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static String getJSONString() throws Exception {
		URL url = new URL(
			"https://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.connect();
		
		StringBuffer sb = new StringBuffer();
		try(BufferedReader reader = new BufferedReader(
			new InputStreamReader(conn.getInputStream()))){
			String line; 
			while ( (line = reader.readLine()) != null) {
				sb.append(line);
			}
		};
		return sb.toString();
	}
	
	static void parseJSON(String json) throws Exception {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		Connection conn = 
				DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/eeit53", prop);
		
		Statement stmt = conn.createStatement();
		stmt.execute("DELETE FROM food");
				
		
		String sql = "INSERT INTO food (name,addr,tel,city,town,picurl,lat,lng)" + 
					" VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		JSONArray root = new JSONArray(json);
		System.out.println("size: " + root.length());
		for (int i=0; i<root.length(); i++) {
			JSONObject row = root.getJSONObject(i);
			pstmt.setString(1, row.getString("Name"));
			pstmt.setString(2, row.getString("Address"));
			pstmt.setString(3, row.getString("Tel"));
			pstmt.setString(4, row.getString("City"));
			pstmt.setString(5, row.getString("Town"));
			pstmt.setString(6, row.getString("PicURL"));
			try {
				pstmt.setDouble(7, Double.parseDouble(row.getString("Latitude")));
			}catch (Exception e) {
				System.out.println(row.getString("Name") +":error1");
				pstmt.setDouble(7, 0);
			}
			try {
				pstmt.setDouble(8, Double.parseDouble(row.getString("Longitude")) );
			}catch(Exception e) {
				System.out.println(row.getString("Name") +":error2");
				pstmt.setDouble(8, 0);
			}
			pstmt.executeUpdate();
		}
		
		pstmt.close();
		conn.close();
	}
	

}
