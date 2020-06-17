package sun.io.readwrite;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
public class WriteFile {

	// Throw exceptions to console:
	public static void
	write(String source,String destination) throws IOException {
	// Reading input by lines:
	List<String> in = ReadFile.readAsList(source);
	BufferedWriter out = new BufferedWriter(
	new FileWriter(destination));
	in.stream().forEach(l->{
		try {

			out.write(l);
			out.newLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	);
	
out.close();
	}
	
	/*Notice one thing here using PrintWriter removes the overhead of the calling newLine() to go to next line, using printwriter it takes care of it using it.
	 * Another thing from java 1.5v onwards we can pass a String fileName or  a File directly to PrintWriter which internally use BufferedWriter*/
	public static void
	writeUsingPrintWriter(String source,String destination) throws IOException {
	// Reading input by lines:
	List<String> in = ReadFile.readAsList(source);
	
	/*PrintWriter out = new PrintWriter(new BufferedWriter(
	new FileWriter(destination)));*/
	
	//Here we can use PrintWriter directly without using BufferedWriter  from java 1.5v onwards 
	PrintWriter out = new PrintWriter(destination);
	
	in.stream().forEach(l->out.println(l));

	out.close();
	}	
	
	public static void
	writeBinary(String source,String destination) throws IOException {
	// Reading input by lines:
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination));
		
		bos.write(ReadFile.readBinary(source));
		bos.close();
	}
	
	
	
	
}
