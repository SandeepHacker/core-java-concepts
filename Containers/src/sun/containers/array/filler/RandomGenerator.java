package sun.containers.array.filler;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import sun.containers.array.filler.SerialGenerator.Character;

public class RandomGenerator {
	
	private static Random r = new Random(47);
	public static class Byte implements Generator<java.lang.Byte>{
		@Override
		public java.lang.Byte next() {
			return (byte)r.nextInt(127);
		}
	}
	public static class Short implements Generator<java.lang.Short>{
	
		@Override
		public java.lang.Short next() {
			return (short)r.nextInt(265);
		}
	}
	public static  class Long implements Generator<java.lang.Long>{
		@Override
		public java.lang.Long next() {
			return r.nextLong();
		}
	}
	
	public static class Integer implements Generator<java.lang.Integer>{
		@Override
		public java.lang.Integer next() {
			return r.nextInt(1_00_000);
		}
	}
	
	public static class String implements Generator<java.lang.String>{
		
	 char[] input=  "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toCharArray();
		@Override
		public java.lang.String next() {
			
			char[] out=new char[5];
			for(int i=0;i<5;i++){
				
			out[i]=input[r.nextInt(input.length-1)];
			}
			return new java.lang.String(out);
		}
	}
		public static class Character implements Generator<java.lang.Character>{
		
		@Override
		public java.lang.Character next() {
			
			return (char)r.nextInt(65535);
			}
	
		
	}
		
		public static class CountryNames implements Generator<java.lang.String>{
			java.lang.String[] counString= CountriesName.getCountriesNames();
			boolean b[] = new boolean[counString.length-1];
			int count=0;
			@Override
			public java.lang.String next() {
				int tmp=0;
				do
				tmp = r.nextInt(counString.length-1);
				while(b[tmp]);
				b[tmp]=true;
				count++;
				if(count==counString.length-1){
					Arrays.fill(b, false);
					count=0;
				}
					
				return counString[tmp];
				}
		
			
		}	
		
		
		public static class LocalDateTime implements Generator<java.time.LocalDateTime>{
			
			
			@Override
			public java.time.LocalDateTime next() {
				Random r = new Random();
			
				java.time.LocalDateTime now = java.time.LocalDateTime.now();
				int year = (60 * 60 * 24 * 365)/2;
				return now.plusSeconds((long) r.nextInt( year));// +- 2 years;
		}
		
		}
public static class LocalDate implements Generator<java.time.LocalDate>{
			
			
			@Override
			public java.time.LocalDate next() {
				Random r = new Random();
			
				java.time.LocalDate now = java.time.LocalDate.now();
				int year = 366/2;
				return now.plusDays((long) r.nextInt( year));// +- 2 years;
		}
		
		}

}
