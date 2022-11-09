package tw.brad.myjava;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.brad.myclass.Bike;

public class JDBC16 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");

		String sql = "SELECT * FROM member WHERE id = ?";
		try {
			Connection conn = 
				DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/eeit53", prop);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 4);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			
//			Object obj = rs.getObject("bike");
//			if (obj instanceof Bike) {
//				System.out.println("bike");
//			}else {
//				System.out.println("non-bike");
//			}
			
			InputStream in2 = rs.getBinaryStream("bike");
			ObjectInputStream oin = new ObjectInputStream(in2);
			Object obj = oin.readObject();
			if (obj instanceof Bike) {
				System.out.println("bike");
			}else {
				System.out.println("non-bike");
			}
			in2.close();
			
			Bike b2 = (Bike)obj;
			System.out.println(b2.getSpeed());
			
			
			FileOutputStream fout = new FileOutputStream("dir2/ball0.png");
			
			InputStream in = rs.getBinaryStream("icon");
			byte[] buf = new byte[1024]; int len;
			while ( (len = in.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			
			in.close();
			
			fout.flush();
			fout.close();
			rs.close();
			pstmt.close();
			conn.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
