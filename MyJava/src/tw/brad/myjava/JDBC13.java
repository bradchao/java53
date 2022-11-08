package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONString;
import org.json.JSONStringer;
import org.json.JSONWriter;

public class JDBC13 {

	public static void main(String[] args) {
		String sql = "select e.lastname, sum(od.unitprice * od.quantity) sum from orders o "
				+ "join employees e on (o.employeeid = e.employeeid) "
				+ "join orderdetails od on (o.orderid = od.orderid) "
				+ "group by e.employeeid "
				+ "order by sum desc";
		
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		
		try {
			Connection conn = 
				DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/eeit53", prop);
			Statement stmt =  conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			JSONStringer js = new JSONStringer();
			
			JSONWriter jw = js.array();
			int i = 0;
			while (rs.next()) {
				String name = rs.getString("lastname");
				String sum = rs.getString("sum");
				//System.out.printf("%s:%s\n", name, sum);
				
				jw.object();
				jw.key("lastname").value(name);
				jw.key("sum").value(sum);
				jw.key("rank").value(++i);
				jw.endObject();
			}
			
			jw.endArray();
			System.out.println(jw.toString());
			
			stmt.close();
			rs.close();
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}


	}

}
