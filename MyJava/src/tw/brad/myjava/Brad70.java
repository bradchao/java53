package tw.brad.myjava;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Brad70 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://pdfmyurl.com/?url=http://www.gamer.com.tw");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			conn.connect();
			
			BufferedOutputStream bout = 
				new BufferedOutputStream(
					new FileOutputStream("dir1/brad.pdf"));
			
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			int len; byte[] buf = new byte[16*1024];
			while ( (len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			bin.close();
			
			bout.flush();
			bout.close();
			
			System.out.println("---");
			System.out.println("OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
