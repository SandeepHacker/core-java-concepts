package sun.containers.set.sortedset;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JavaBigDecimal{
	
	static class Inner{
		private class Private{
			private String powerof2(int num){
				return ((num&num-1)==0)?"power of 2":"not a power of 2";
			}
		}
	}
	
	static boolean  isPrime(int n){
	    for(int i=2;i<=n/2;i++){
	        if(n%i==0)
	        return false;
	    }
	    return true;
	}

    public static void main(String []argh)
    {
/*    	sun.containers.set.sortedset.JavaBigDecimal.Inner.Private i = new Inner().new Private();
       System.out.println("JavaBigDecimal.main()"+new Inner().new Private().powerof2(22));*/
    	System.out.println("JavaBigDecimal.main()"+isPrime(1));
    }
    
    
    static void isPrime(String s){
    	BigInteger bi = new BigInteger(s);
    	System.out.println("JavaBigDecimal.isPrime()"+bi.isProbablePrime(0));
    }


}