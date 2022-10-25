package tw.brad.myjava;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Brad56 {

	public static void main(String[] args) {
		Student s1 = new Student("brad", 20, 30, 40);
		System.out.printf("%s:%d:%f\n", s1.getName(), s1.score(), s1.avg());
		Student s2 = new Student("eric", 60, 70, 80);
		
		try {
			ObjectOutputStream oout = 
				new ObjectOutputStream(new FileOutputStream("dir1/brad.score"));
			oout.writeObject(s1);
			oout.writeObject(s2);
			oout.flush();
			oout.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
class Student implements Serializable{
	private int ch, eng, math;
	private String name;
	
	Student(String name, int ch, int eng, int math){
		this.name = name;
		this.ch = ch; this.eng = eng; this.math = math;
	}
	String getName() {return name;}
	int score() {return ch+eng + math;}
	double avg() {return score() / 3.0;}
}