package sun.containers.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import sun.containers.fillers.MapContainer;
import sun.containers.fillers.PairGenerator;

public class TestMapFunctionality {
	
	static void testAssociativeArray(){
		AssociativeArray<String,String> map = new AssociativeArray<String,String>();
		map.put("S", "SUN");
		map.put("M", "MUN");
		map.put("N", "NUN");
		map.put("sky", "blue");
		map.put("grass", "green");
		map.put("ocean", "dancing");
		map.put("tree", "tall");
		map.put("earth", "brown");
		System.out.println("TestMapFunctionality.testAssociativeArray()"+map);
		System.out.println(map.get("M"));
		System.out.println(map.get("tree"));
		System.out.println(map.get("Ms"));
	}
	public static void main(String[] args) {
//		testAssociativeArray();
		testMapFunctionality(new HashMap<Character, String>());
		testLinkedHashMap();
	}
	 static void printKeys(Map<Character,String> map) {
		 System.out.println("Size = " + map.size() + ", ");
		 System.out.println("Keys: ");
		 System.out.println(map.keySet()); // Produce a Set of the keys
		}
	public static void testMapFunctionality(Map<Character,String> map){
		System.out.print(map.getClass().getSimpleName());
		map.putAll(new MapContainer<Character, String>(new PairGenerator.AlpahtesWords(), 20));
		// Map has ‘Set’ behavior for keys:
		map.putAll(new MapContainer<Character, String>(new PairGenerator.AlpahtesWords(), 6));
		printKeys(map);
		// Producing a Collection of the values:
		System.out.println("Values: ");
		System.out.println(map.values());
		System.out.println(map);
		System.out.println("map.containsKey(Z): " + map.containsKey('Z'));
		System.out.println("map.containsKey(E): " + map.containsKey('E'));
		System.out.println("map.get(E): " + map.get('E'));
		System.out.println("map.containsValue(\"Kite\"): "
		+ map.containsValue("Kite"));
		Character key = map.keySet().iterator().next();
		System.out.println("First key in map: " + key);
		map.remove(key);
		printKeys(map);
		map.clear();
		System.out.println("map.isEmpty(): " + map.isEmpty());
		map.putAll(new MapContainer<Character, String>(new PairGenerator.AlpahtesWords(), 10));
		// Operations on the Set change the Map:
		map.keySet().removeAll(map.keySet());
		System.out.	println("map.isEmpty(): " + map.isEmpty());
	}
	
	/*You can see from this output after access six elements using for loop when we print the map the order is completely changed based on the LRU
	*Least Recently Used algorithm which means the least accessed elements are at the begning of the list 
	This LRU has been activated using the LinkedHashMap Constructor argument true in accessorder parameter*/
	static void testLinkedHashMap(){
		LinkedHashMap<Character,String> linkedMap =
				new LinkedHashMap<Character,String>(
						new MapContainer<Character, String>(new PairGenerator.AlpahtesWords(), 10));
		System.out.println(linkedMap);
				// Least-recently-used order:
				linkedMap =
				new LinkedHashMap<Character,String>(16, 0.75f, true);//enable LRU
				linkedMap.putAll(new MapContainer<Character, String>(new PairGenerator.AlpahtesWords(), 10));
				System.out.println(linkedMap);
				for(char  i = 65; i < 71; i++) // Cause accesses:
				System.out.println(linkedMap.get(i));
				System.out.println(linkedMap);
				linkedMap.get(0);
				System.out.println(linkedMap);
	}

}
