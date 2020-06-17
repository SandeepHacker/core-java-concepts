package sun.containers.fillers;

import java.util.Collections;
import java.util.TreeMap;

import sun.containers.array.filler.RandomGenerator;
import sun.containers.array.filler.RandomGenerator.CountryNames;
import sun.containers.array.filler.SerialGenerator;
import sun.containers.array.filler.SerialGenerator.Character;
import sun.containers.array.filler.SerialGenerator.Integer;

public class TestCollectionAbstractGenerator {
	
	
	
	public static void main(String[] args) {
		java.util.TreeMap<String,String> map = ContainerGenerator.loadTreeMap(new PairGenerator.CountryCapital(), 60);
		System.out.println(map);
		java.util.Set<java.lang.Character> set = ContainerGenerator.loadHashSet(new SerialGenerator.Character(), 26);
		System.out.println(set);
		java.util.List<String> countries = ContainerGenerator.loadArrayList(new RandomGenerator.CountryNames(), 10);
		System.out.println(countries);
		
		Collections.shuffle(countries);//Shuffling elements in ArrayList
		System.out.println(countries);
		
		Collections.shuffle(countries);//Shuffling elements in ArrayList
		System.out.println(countries);
	}

}
