package sun.io.standard;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadingStandardInput {
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("D:\\FileIO\\New folder - Copy\\A - Copy (1).txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		PrintWriter pw = new PrintWriter(System.out);
		while((s=br.readLine())!=null && s.length()!=0){
			pw.println(s);
			
		}
		pw.close();
		br.close();
	
	}
	

}
