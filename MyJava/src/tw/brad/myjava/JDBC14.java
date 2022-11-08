package tw.brad.myjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.json.JSONString;
import org.json.JSONStringer;
import org.json.JSONWriter;

public class JDBC14 {
	/*
	 * {
		"orderid" : 10248,
		"customerid": "VINET",
		"empolyeeid": 5
		"detail" :[ 
				{
					"productid" : 123,
					"price" : 111,
					"qty" : 12
				},
				{
					"productid" : 123,
					"price" : 111,
					"qty" : 12
				},
				{
					"productid" : 123,
					"price" : 111,
					"qty" : 12
				}
			]
		}
	 */
	public static void main(String[] args) {
		String sql = "select o.OrderID, o.CustomerID, o.EmployeeID, " +
				"od.ProductID, od.UnitPrice, od.Quantity " + 
				"from orders o " + 
				"join orderdetails od on "+
				"(o.orderid = od.orderid) " + 
				"where o.orderid = 10248";
		
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
			
			JSONWriter jw = js.object();
			
			rs.next();
			String orderid = rs.getString("orderid");
			String customerid = rs.getString("customerid");
			String employeeid = rs.getString("employeeid");
			jw.key("orderid").value(orderid);
			jw.key("customerid").value(customerid);
			jw.key("empolyeeid").value(employeeid);
			
			JSONWriter detail = jw.key("detail");
			JSONWriter row = detail.array();
			row.object();
			row.key("productid").value(rs.getString("productid"));
			row.key("price").value(rs.getString("unitprice"));
			row.key("qty").value(rs.getString("quantity"));
			row.endObject();
			
			while (rs.next()) {
				row.object();
				row.key("productid").value(rs.getString("productid"));
				row.key("price").value(rs.getString("unitprice"));
				row.key("qty").value(rs.getString("quantity"));
				row.endObject();
			}
			
			detail.endArray();
			jw.endObject();
			
			stmt.close();
			rs.close();
			conn.close();
			System.out.println(jw.toString());
		}catch(Exception e) {
			System.out.println(e);
		}


	}

}
