package sun.containers.own;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import sun.containers.array.filler.Generator;
import sun.containers.fillers.Pair;
import sun.containers.fillers.PairGenerator;
import sun.containers.own.ClassicMap.PairIterator;

public class TestOwnMap {
	
static<K,V> Map<K,V> loadHashMap(Generator<Pair<K,V>> gen, int size){
	Map<K,V> map = new HashMap<K,V>();
	for(int i=0;i<size;i++){
		Pair<K,V> pair =gen.next();
		map.put(pair.k, pair.v);
	}
	return map;
}
public static ClassicMap<String, String> laodClassicMap(Generator<sun.containers.fillers.Pair<String, String>>gen ,int size){
	ClassicMap<String, String> clasmap = new ClassicMap<String, String>();
	
	for(int i=0;i<size;i++){
		sun.containers.fillers.Pair<String, String> pair = gen.next();
		clasmap.put(pair.k, pair.v);
	}
	return clasmap;
}
	
	public static void main(String[] args) {

		ClassicMap<String,String> map = new ClassicMap<String,String>();
//	ClassicMap<String,String> cmap = laodClassicMap(new PairGenerator.CountryCapital(), 300);
//			HashMap<String,String> hmap2 = (HashMap<String, String>) loadHashMap(new PairGenerator.CountryCapital(), 40000);
		HashMap<String,String> hmap = new HashMap<String,String>();
		hmap.put("Sun", "Moon");
		hmap.put("Susn", "Moons");
		hmap.put("Susasn", "Moosans");
		hmap.put("SASA", "Danger");
		
		System.out.println("TestOwnMap.main()"+hmap);
		map.put("Sun", "Hot");
		System.out.println("TestOwnMap.main()"+map);
		map.put("Damage", "UFC");
		map.put("SASA", "Danger");
		map.put("sda", "Ram:");

		map.put("Damages", "UFC");
		map.put("SASAA", "Danger");
		map.put("sda", "Ram:");
		map.put("AWS", "Cloud");
		map.put(new String("AWS2"), "Cloud");
		map.put("AssWS", "Cloud");
		System.out.println("TestOwnMap.main()"+map.size());
//		System.out.println("TestOwnMap.main()"+cmap.size());

		System.out.println("TestOwnMap.main()"+map);


	
//	int index = Math.abs("sda".hashCode())%7;	


//		System.out.println("TestOwnMap.main()"+cmap.keys());
		/*testMap(hmap);
		testMap(map);
testMap(cmap);
testMap(hmap2);*/
	System.out.println(map);
	System.out.println("TestOwnMap.mainremove()"+map.remove("Sdun"));
	System.out.println(map);

	}
	static void testMap(HashMap map){
		System.out.println("Hash Map");
		long start=System.currentTimeMillis();
		for(int x=0;x<10;x++){
		for(int i=0;i<=100000;i++){
			map.containsValue("Hot");
			map.get("INDIA");

			/*map.keySet();
			map.values();*/
		}
		long end=System.currentTimeMillis();
		
		System.out.println("Total time taken by hashmap::"+(end-start));
	}
	}
		
	
	static void testMap(ClassicMap map){
		System.out.println("Classic Map");
		for(int x=0;x<10;x++){
		long start=System.currentTimeMillis();
		for(int i=0;i<=100000;i++){
			map.containsValue("Hot");
			map.get("INDIA");
			/*map.keys();
			map.values();*/
		}
		long end=System.currentTimeMillis();
		
		System.out.println("Total time taken by classicmap::"+(end-start));
	}
	}
	
}
