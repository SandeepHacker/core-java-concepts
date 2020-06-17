package sun.containers.fillers;

import java.util.Arrays;
import java.util.Random;

import sun.containers.array.filler.CountriesName;
import sun.containers.array.filler.Generator;
import sun.containers.array.filler.SerialGenerator.Character;

public class PairGenerator {
	
	public static class AlpahtesWords implements Generator<Pair<java.lang.Character,java.lang.String>>{
		
		
		private Character gen = new Character(true);
		private java.lang.String[] words;
		private int i;
		public AlpahtesWords() {
		words=getWords();
		}
			
			public sun.containers.fillers.Pair<java.lang.Character,java.lang.String> next() {
				if(i==words.length-1)
					i=0;
		return	new Pair<java.lang.Character,java.lang.String>(gen.next(), words[i++]);
			};
			
			private java.lang.String[] getWords(){
				return ("Apple Ball Cat Dog Elephant Frog Goat Hacker IceCream Jackal Kite Lion Monkey Nest Onion Peacock Queen "+
			"Rat Sun Talent Umbrella Van Watch Xmas Zebra").split(" ");
			}
			
			
		}
	
public static class AlpahtesCountry implements Generator<Pair<java.lang.Character,java.lang.String>>{
		
		
		private Character gen = new Character(true);
		private Random r = new Random(47);
	
		private java.lang.String[] words=CountriesName.getCountriesNames();
		int i=0;
			public sun.containers.fillers.Pair<java.lang.Character,java.lang.String> next() {
				java.lang.String s="";
				java.lang.Character charec = gen.next();
		
			if(charec!='W' && charec!='X'){
				do{
					s=words[r.nextInt(words.length-1)];
				}
				while(s.charAt(0)!=charec);
				return	new Pair<java.lang.Character,java.lang.String>(charec, s);
			}
		return	new Pair<java.lang.Character,java.lang.String>(charec, "N/A");
			};
			
			
		}

public static class CountryCapital implements Generator<Pair<java.lang.String,java.lang.String>>{
	
	
	private Character gen = new Character(true);
	private Random r = new Random(47);

	private java.lang.String[][] words=CountriesName.getCountryCapitals();
	int index=-1;
		public sun.containers.fillers.Pair<java.lang.String,java.lang.String> next() {
			if(index==words.length-1)
				index=-1;
		index++;
			return	new Pair<java.lang.String,java.lang.String>(words[index][0], words[index][1]);
		
		};
		
		
	}

public static class NumberSquareCube implements Generator<Pair<java.lang.Long,java.lang.Long>>{
	boolean flag=false;
	public NumberSquareCube( ){
		
	}
	public NumberSquareCube(boolean cube) {
		flag=cube;
	}
	long index=-1;
		public sun.containers.fillers.Pair<java.lang.Long,java.lang.Long> next() {
			++index;
			if(flag)
			return	new Pair<java.lang.Long,java.lang.Long>(index,(index*index*index));
		
			return	new Pair<java.lang.Long,java.lang.Long>(index,(index*index));
		};
		
		
	}
}
