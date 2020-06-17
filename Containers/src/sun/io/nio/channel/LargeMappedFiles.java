package sun.io.nio.channel;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/*To do both writing and reading, we start with a RandomAccessFile, get a channel for that file, and then call map( ) to produce a MappedByteBuffer, 
 which is a particular kind of direct buffer. Note that you must specify the starting point and the length of the region that you want to map in the file; 
 this means that you have the option to map smaller regions of a large file.
 The file created with the preceding program is 128 MB long, which is probably larger than your OS will allow in memory at one time. 
 The file appears to be accessible all at once because only portions of it are brought into memory, and other parts are swapped out. 
 This way a very large file (up to 2 GB) can easily be modified. 
 Note that the file-mapping facilities of the underlying operating system are used to maximize performance.*/
public class LargeMappedFiles {
	
	static int length = 0x8FFFFFF; // 128 MB

	public static void main(String[] args) throws Exception {
		
		//r -read
		//w-write
		//rw - readwrite
		MappedByteBuffer out = new RandomAccessFile(
				"D:\\FileIO\\New folder - Copy\\A - Copy (4).txt", "rw")
				.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
		for (int i = 0; i < length; i++)
			out.put((byte) i);

		System.out.println("Finished writing");
		for (int i = length / 2; i < length / 2 + 6; i++)
			System.out.println(out.get(i));
	}
}
