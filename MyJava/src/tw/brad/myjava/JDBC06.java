package tw.brad.myjava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
			System.out.println(json);
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
	
	static void parseJSON(String json) {
		
	}
	

}
