package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;

public class AllIterationsOverMap {
	
	public static void main(String[] args) {
		Map<Integer, String> map;
		map = new HashMap<>();
		
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");
		
		// (0)
		System.out.println(map);
		
		// (1)
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.printf("%s=%s ", key, value);
		}
		System.out.println();
		
		// (2)
		Iterator<Map.Entry<Integer, String>> it =
				map.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Integer, String> entry = it.next();
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.printf("%s=%s ", key, value);
		}
		System.out.println();

		// (3)
		for (Integer key : map.keySet()) {
			String value = map.get(key);
			System.out.printf("%s=%s ", key, value);
		}
		System.out.println();
		
		// (4)
		map.forEach(new BiConsumer<Integer, String>() {
			public void accept(Integer key, String value) {
				System.out.printf("%s=%s ", key, value);
			}
		});
		System.out.println();

	}
	
}
