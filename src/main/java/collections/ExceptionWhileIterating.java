package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExceptionWhileIterating {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}
		
		for (Integer el : list) { // exception, removing while iterating
			list.remove(0);
			System.out.println("ok");
		}
		System.out.println(list);
	}
}