package sun.io.standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessControl {
	private static class OSCommandException extends RuntimeException{
		public OSCommandException() {
			// TODO Auto-generated constructor stub
		}
		public OSCommandException(String s) {
		super(s);
		}
	}
	
	public static void main(String[] args) throws Exception {
		//This will not work and throw error reason is mentioned below avoe process method
		process("javap", "ReadingStandardInput");
//		process("ipconfig");
	}
	/*Note a very important thing here is when we pass command to ProcessBuilder everyword should be one element of the array.
	Suppose we want to pass git --version we have pass like git as first element and --verison as second element.
	If we pass directly the whole command as a single string I will not work*/
	public static void process(String... command) throws Exception {
		boolean flag=false;

		Process process =
				new ProcessBuilder(command).start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String s;
		while((s=br.readLine())!=null){
			System.out.println(s);
		}
		BufferedReader br1 = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		StringBuilder sb = new StringBuilder();
		while((s=br1.readLine())!=null){
			sb.append(s+"\n");
			flag=true;
		}
		if(flag){
			throw new OSCommandException(sb.toString());
			
		}
		
		
	}

}
