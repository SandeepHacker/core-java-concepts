package sun.containers.map.hashing;

import java.util.HashMap;

import sun.containers.array.filler.Generator;
import sun.containers.fillers.Pair;
import sun.containers.fillers.PairGenerator;
import sun.containers.map.TestMapFunctionality;

public class TestCustomMap {
	
	public static void main(String[] args) {
		SlowMap<Character,String> slowMap = new SlowMap<Character, String>();
		
		Generator<Pair<Character, String>> gen = new PairGenerator.AlpahtesWords();
		
		for(int i =0;i<=10;i++){
			Pair<Character, String> pair=gen.next();
		slowMap.put(pair.k, pair.v);
		}
		
		System.out.println(slowMap);
		TestMapFunctionality.testMapFunctionality(slowMap);
		Pair<Character, String> pair=gen.next();
		System.out.println("Pair::"+pair);

		HashMap<Character,String> hm = new HashMap<Character,String>();
		for(int i =0;i<=1;i++){
			Pair<Character, String> pair1=gen.next();
		hm.put(pair1.k, pair1.v);
		}
		System.out.println(hm);
		/*This below  line entrySet().add() throws UnsupportedOperationException because HashMap EntrySet return a read-only Set 
		which doesn't include  add operations
		entrySet().addAll() doesn't throw any exception  but  the collection is not really but in SlowMap both works perfectly
		These two are customized in SlowMap
		*/
//		hm.entrySet().add(new MapEntry<Character,String>(pair.k,pair.v)); 
		hm.entrySet().addAll(slowMap.entrySet());
		System.out.println("HashMap:::"+hm);
		slowMap.entrySet().add(new MapEntry<Character,String>(pair.k,pair.v));
		slowMap.entrySet().add(new MapEntry<Character,String>(pair.k,pair.v));
		System.out.println("SlowMap::"+slowMap);
		slowMap.entrySet().addAll(hm.entrySet());
		System.out.println("SlowMap::"+slowMap);
		
		
		SimpleHashMap<Character, String> simpleHashMap = new SimpleHashMap<Character, String>();
		simpleHashMap.put('A',"Answer");
		
		
		
		System.out.println("SimpleHashMap:::"+simpleHashMap);
		System.out.println("Old Value:::"+simpleHashMap.put('A',"Apple"));
		System.out.println("SimpleHashMap:::"+simpleHashMap);
		System.out.println("SimpleHashMap:::"+simpleHashMap.get('A'));
	}

}
