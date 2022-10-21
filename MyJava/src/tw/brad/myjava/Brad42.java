package tw.brad.myjava;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import tw.brad.myclass.Bike;

public class Brad42 {

	public static void main(String[] args) {
		HashMap<String, Object> person = new HashMap<>();
		person.put("name", "Brad");
		person.put("height", 176);
		person.put("weight", 80);
		person.put("gender", false);
		System.out.println("Gender:" + person.get("gender"));
		System.out.println("---");
		
		Set<String> keys = person.keySet();
		for (String key : keys) {
			System.out.println(key + ":" + person.get(key));
		}
		
		System.out.println("---");
		
		TreeSet<Integer> lotters = new TreeSet<>();
		while (lotters.size()<6) {
			lotters.add((int)(Math.random()*49+1));
		}
		person.put("lottery", lotters);
		Bike bike = new Bike();
		person.put("bike", bike);
		
		TreeSet<Integer> temp = (TreeSet<Integer>)person.get("lottery"); 
		for(Integer v : temp) {
			System.out.println(v);
		}
		System.out.println("---");
		Bike myBike = (Bike)person.get("bike");
		myBike.upSpeed(); myBike.upSpeed();myBike.upSpeed();myBike.upSpeed();
		System.out.println(myBike.getSpeed());
		
		
		
		
		
	}

}
