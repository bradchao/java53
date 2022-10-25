package tw.brad.myjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import tw.brad.myclass.Bike;

public class Brad58 {
	public static void main(String[] args) {
		Brad583 obj = new Brad583();
		try {
			ObjectOutputStream oout = 
					new ObjectOutputStream(
							new FileOutputStream("dir1/b.obj"));
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			System.out.println("OK1");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("----");
		
		try {
			ObjectInputStream oin = 
				new ObjectInputStream(
					new FileInputStream("dir1/b.obj"));
			Object obj2 = oin.readObject();
			oin.close();
			System.out.println("OK2");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
class Brad581 implements Serializable {
	Brad581(){System.out.println("Brad581()");}
}
class Brad582 extends Brad581  {
	Brad582(){System.out.println("Brad582()");}
}
class Brad583 extends Brad582  {
	private Bike bike;
	Brad583(){System.out.println("Brad583()"); bike = new Bike();}
}
