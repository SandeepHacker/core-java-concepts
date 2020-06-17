package sun.containers.set.sortedset;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;


public class Test2 {
	
	  public static void main(String[] args) {
/*	        int number = 4;
	      System.out.println("Test2.main()"+ findSpecialNumber(7, 8, 5));
System.out.println("Test2.main()"+findPrimeNumberSums(6));	      

		  /*	if(num<10)
		  			System.out.printf("%s%"+(15-s1.length())+"s%d%d%d", s1," ",0,0,num);

		  		else if(num<100)
		  			System.out.printf("%s%"+(15-s1.length())+"s%d%d", s1," ",0,num);	
		  		else
		  			System.out.printf("%s%"+(15-s1.length())+"s%d", s1," ",num);*/

		  		
	  

	       /* Scanner in = new Scanner(System.in);
	        String month = in.next();
	        String day = in.next();
	        String year = in.next();
	        
	        Calendar c = Calendar.getInstance(); 
	        c.set(Integer.parseInt(year), Integer.parseInt(month)-1,Integer.parseInt(day));
	String dayOfWeek = getDayOfWeek(c.get(Calendar.DAY_OF_WEEK));
	System.out.println(dayOfWeek.toUpperCase() );*/
		  BigDecimal bif = new BigDecimal("0.1");
		  BigDecimal bif1 = new BigDecimal("1");
		  System.out.println("Test2.main()"+(bif==bif1));
	    }
	  
	  public static String findDay(int month, int day, int year) {
          
          Calendar c = Calendar.getInstance(); 
          c.set(year, (month-1),day);
 String which_day="";
System.out.println("Test2.findDay()"+c.get(Calendar.DAY_OF_WEEK));
switch(c.get(Calendar.DAY_OF_WEEK)){
case 1:
  which_day= "SUNDAY"; 
  break;
case 2:
  which_day= "MONDAY"; 
  break;
case 3:
  which_day= "TUESDAY"; 
  break;
case 4:
  which_day= "WEDNESDAY";
  break; 
case 5:
  which_day= "THURSDAY"; 
  break;
case 6:
  which_day= "SATURDAY"; 
  break;
default:
  which_day= "SUNDAY"; 
}
return which_day;
}
	    
	    private static String getDayOfWeek(int value){
	    String day = "";
	    switch(value){
	    case 1:
	        day="Sunday";
	        break;
	    case 2:
	        day="Monday";
	        break;
	    case 3:
	        day="Tuesday";
	        break;
	    case 4:
	        day="Wednesday";
	        break;
	    case 5:
	        day="Thursday";
	        break;
	    case 6:
	        day="Friday";
	        break;
	    case 7:
	        day="Saturday";
	        break;
	    }
	    return day;
	    }
	  
	  
	  static long findSpecialNumber(int decreasingCost, int increasingCost, int number)
	  {
		  int forward=number+1,backward=number-1;
		  while(!findPrimeNumberSums(forward)){
			  forward++;
		  }
	  
		  while(backward>0 && !findPrimeNumberSums(backward)){
			  backward--;
		  }
//		  System.out.println("Test2.findSpecialNumber()"+forward+"---------"+backward);
if(backward!=0){
		  if(backward<forward){
			  return (number-backward)*decreasingCost;
		  }else if(forward<backward){
			  return (forward-number)*increasingCost;
		  }else{
			  if(decreasingCost>increasingCost){
				  return (forward-number)*increasingCost;
			  }
				  return (number-backward)*decreasingCost;
		  }
}else{
  return (forward-number)*increasingCost;
}
	  }
	  static boolean findPrimeNumberSums(int number){
	        for (int i = 2; i <= number / 2; ++i) {
	            if ((sum_of_primes(i) && sum_of_primes(number-i)) && i!=(number-i) ) {
//	            	System.out.println("Test2.findPrimeNumberSums()"+i+"--------"+(number-i));
	                    return true;
	                }
	            }

	        return false;
	  }
	  
	    //function to check if given number is prime or not
	    static boolean sum_of_primes(int num) {
	        boolean isPrime = true;
if(num<3){
	return false;
}
	        for (int i = 2; i <= num / 2; ++i) {
	            if (num % i == 0) {
	                isPrime = false;
	                break;
	            }
	        }

	        return isPrime;
	    }

}

/*17
9223372036854775808
9223372036854775807
-9223372036854775808
-9223372036854775807
4294967296
4294967295
-4294967296
-4294967295
65536
65535
-65536
-65535
256
255
-256
-255
12222222222222222222222222222222222222222221
Expected Output
Download
9223372036854775808 can't be fitted anywhere.
9223372036854775807 can be fitted in:
* long
-9223372036854775808 can be fitted in:
* long
-9223372036854775807 can be fitted in:
* long
4294967296 can be fitted in:
* long
4294967295 can be fitted in:
* long
-4294967296 can be fitted in:
* long
-4294967295 can be fitted in:
* long
65536 can be fitted in:
* int
* long
65535 can be fitted in:
* int{-truncated-}
*/