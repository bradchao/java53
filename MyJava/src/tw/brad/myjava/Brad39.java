package tw.brad.myjava;

import java.util.HashSet;
import java.util.TreeSet;

public class Brad39 {

	public static void main(String[] args) {
		TreeSet<Integer> lotters = new TreeSet<>();
		while (lotters.size()<6) {
			lotters.add((int)(Math.random()*49+1));
		}
		System.out.println(lotters);
	}

}
