package sun.io.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
	
	public static void main(String[] args) throws IOException {
//		writeAtEndOfFile("D:\\FileIO\\New folder - Copy\\A - Copy (2).txt","D:\\FileIO\\New folder - Copy\\A - Copy (3).txt");
		copyingUsingChannel("D:\\FileIO\\New folder - Copy\\A - Copy (2).txt","D:\\FileIO\\New folder - Copy\\A - Copy (3).txt");
	}

	public static void writeUsingChannel(String source,String filename) throws IOException{
	FileOutputStream fos = new FileOutputStream(filename);
	FileChannel fc = fos.getChannel();
	fc.write(ByteBuffer.wrap(readUsingChannel(source)));
	fc.close();
	fos.close();
	}
	
	
	public static void  copyingUsingChannel(String source,String destination) throws IOException{
		FileInputStream fis = new FileInputStream(source);
		FileOutputStream fos = new FileOutputStream(destination);
		FileChannel fic = fis.getChannel();
		FileChannel foc = fos.getChannel();
		
		//We can copy or transfer data from one stream to other
		
		fic.transferTo(0, fic.size(), foc);
		//OR
//		foc.transferFrom( fic,0, fic.size());
		
	}
	
	public static void writeAtEndOfFile(String source,String filename) throws IOException{
		RandomAccessFile rf = new RandomAccessFile(filename, "rw");
		FileChannel fc = rf.getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap(readUsingChannel(source)));
		fc.close();
		}
	
	/*Once you call read( ) to tell the FileChannel to store bytes into the ByteBuffer, you must
	call flip( ) on the buffer to tell it to get ready to have its bytes extracted (yes, this seems a bit
	crude, but remember that it’s very low-level and is done for maximum speed). And if we were
	to use the buffer for further read( ) operations, we’d also have to call clear( ) to prepare it
	for each read( ).*/
	public static byte[] readUsingChannel(String filename) throws IOException{
	FileInputStream fis = new FileInputStream(filename);
	FileChannel fc = fis.getChannel();
	ByteBuffer bf = ByteBuffer.allocate(fis.available());
	fc.read(bf);
	bf.flip();
	fc.close();
	fis.close();
	return bf.array();
	}
	
	
	
}
