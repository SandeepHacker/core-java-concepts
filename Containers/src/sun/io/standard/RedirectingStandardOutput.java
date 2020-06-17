package sun.io.standard;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
/*The Java System class allows you to redirect the standard input, output, and error I/O streams using simple static method calls:
setIn(InputStream)
setOut(PrintStream)
setErr(PrintStream)*/
public class RedirectingStandardOutput {
	
	public static void main(String[] args) throws FileNotFoundException {
		PrintStream pos = new PrintStream(new BufferedOutputStream(new FileOutputStream("D:\\FileIO\\New folder - Copy\\A - Copy (3).txt")),true);
		System.setOut(pos);
		System.setErr(pos);
		for(int i =1; i<=100;i++){
			if(i%2==1){
				System.out.println(i);
			}
		}
		
		System.out.println(10/0);
		
	}

}
