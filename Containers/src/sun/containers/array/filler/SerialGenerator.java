package sun.containers.array.filler;

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
		
		

}
