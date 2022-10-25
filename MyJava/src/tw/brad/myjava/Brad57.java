package tw.brad.myjava;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Brad57 {

	public static void main(String[] args) {
		try {
			ObjectInputStream oin = 
				new ObjectInputStream(
					new FileInputStream("dir1/brad.score"));
			
			Object obj1 = oin.readObject();
			Student s1 = (Student)obj1;
			System.out.printf("%s:%d:%f\n", s1.getName(), s1.score(), s1.avg());

			Object obj2 = oin.readObject();
			Student s2 = (Student)obj2;
			System.out.printf("%s:%d:%f\n", s2.getName(), s2.score(), s2.avg());

			oin.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
