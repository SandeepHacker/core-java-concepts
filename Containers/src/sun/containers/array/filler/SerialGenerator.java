package sun.containers.array.filler;

import sun.containers.fillers.Pair;

public class SerialGenerator {
	
	public static class Byte implements Generator<java.lang.Byte>{
		byte b=0;
		@Override
		public java.lang.Byte next() {
			if(b==127)
				b=0;
			return ++b;
		}
	}
	public static class Short implements Generator<java.lang.Short>{
		short s=0;
		@Override
		public java.lang.Short next() {
			// TODO Auto-generated method stub
			return ++s;
		}
	}
	public static  class Long implements Generator<java.lang.Long>{
		long l=0L;
		@Override
		public java.lang.Long next() {
			// TODO Auto-generated method stub
			return ++l;
		}
	}
	
	public static class Integer implements Generator<java.lang.Integer>{
		int i=0;
		@Override
		public java.lang.Integer next() {
			// TODO Auto-generated method stub
			return ++i;
		}
	}
	
	public static class String implements Generator<java.lang.String>{
		
		Character c =new Character();
		@Override
		public java.lang.String next() {
			char[] out=new char[5];
			for(int i=0;i<5;i++)
				out[i]=c.next();
		
			return new java.lang.String(out);
		}
	}
		public static class Character implements Generator<java.lang.Character>{
			
			int j;
			boolean caps=false;
				
			public Character() {
				j='a';
			}
			public Character(boolean flag) {
				caps=flag;
				j='A';
			}
		
		@Override
		public java.lang.Character next() {
			if(caps){
			if(j==91)
				j='A';
			return (char)j++;
			}
			if (j==123)
					j='a';
			return (char)j++;
			}
	
		
	}
		
		
		public static class CountryNames implements Generator<java.lang.String>{
int index=0;
			java.lang.String[] counString= CountriesName.getCountriesNames();
			@Override
			public java.lang.String next() {
				if(index==counString.length)
					index=0;
				return counString[index++];
			}
			
			
		}
		
		public static class AlphaNumeric implements Generator<java.lang.String>{

			private Generator<java.lang.Character> alpha = new Character(true);
			private Generator<java.lang.Integer> numeric = new Integer();
			java.lang.Character ch=alpha.next();
			java.lang.Integer nu=null;
			int counter=0;
			 int numericLimit;
			public AlphaNumeric() {
				this.numericLimit=9;
			}
			
			public AlphaNumeric(int numericLimit) {
				this.numericLimit=numericLimit;
			}
			
			
			@Override
			public java.lang.String next() {
				StringBuilder sb = new StringBuilder();	
				nu=numeric.next();
				sb.append(ch).append(nu);
			
				counter++;
				if(counter==numericLimit){
					numeric=new Integer();
					ch=alpha.next();
					counter=0;
				}
				return new java.lang.String(sb);
			}
			
		}
	
		
		

}
