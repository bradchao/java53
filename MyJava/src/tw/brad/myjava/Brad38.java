package tw.brad.myjava;

import java.util.HashSet;
import java.util.Iterator;

public class Brad38 {

	public static void main(String[] args) {
		// 迭代器 iterator, iterable 可迭代
		// Set : 1. 元素不會重複 2. 沒有順序性
		// List: 1. 元素可以重複 2. 有順序性
		
		HashSet set = new HashSet();
		set.add("Brad");
		set.add(new String("Brad"));
		set.add("Brad");
		set.add(123);	// int => autoboxing = >Integer Object
		set.add(12.3);
		set.add("iSpan");
		System.out.println(set.size());
		System.out.println(set);
		
//		Iterator it = set.iterator();
//		while (it.hasNext()) {
//			System.out.println(it.next()); 
//		}
		
		for (Object obj : set) {
			System.out.println(obj);
		}
		
		
		
		
		
		

	}

}
