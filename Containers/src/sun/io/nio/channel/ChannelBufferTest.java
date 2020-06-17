package sun.io.nio.channel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class ChannelBufferTest {
	
	
	public static void main(String[] args) throws IOException {
	
		
		FileInputStream fis = new FileInputStream("D:\\FileIO\\New folder - Copy\\A - Copy (2).txt");
		FileChannel fic = fis.getChannel();
		ByteBuffer bf = ByteBuffer.allocate(fis.available());
		fic.read(bf);
		//Before reading the buffer we need to call flip()
		bf.flip();
		/*The buffer contains plain bytes, and to turn these into characters, we must either encode
		them as we put them in (so that they will be meaningful when they come out) or decode them
		as they come out of the buffer. This can be accomplished using the Charset Class*/
		System.out.println("ChannelBufferTest.main(1)"+bf.asCharBuffer());
		//The below line is to rewind() the buffer pointer to zero point 
			bf.rewind();
		//The below line uses the Charset class to decode the ByteBuffer to as  char buffer
		System.out.println("ChannelBufferTest.main(2)"+Charset.defaultCharset().decode(bf));
		/*Another alternative is to encode( ) using a character set that will result in something printable when the file is read,
		 *  as you see in the third part of BufferToText.java. Here, UTF-16BE is used to write the text into the file, and when it is read, 
		 *  all you must do is convert it to a CharBuffer, and it produces the expected text.*/
			FileOutputStream fos = new FileOutputStream("D:\\FileIO\\New folder - Copy\\A - Copy (3).txt");
		FileChannel foc = fos.getChannel();
		
		foc.write(ByteBuffer.wrap("Some More Text".getBytes("UTF-16BE")));
		foc.close();
		
		
	fis = new FileInputStream("D:\\FileIO\\New folder - Copy\\A - Copy (3).txt");
	fic = fis.getChannel();
	bf.clear();
	bf.allocate(fis.available());
	fic.read(bf);
	bf.flip();
	System.out.println("ChannelBufferTest.main(3)"+bf.asCharBuffer());
		
	/*Finally, another option is to write using charbuffer,  you see what happens if you write to the ByteBuffer through a CharBuffer 
	Note that 24 bytes are allocated for the ByteBuffer. 
	Since each char requires two bytes, this is enough for 12 chars, but "Some text" only has 9.
	 The remaining zero bytes still appear in the representation of the CharBuffer produced by its toString( ), as you can see in the output.*/
	 fos = new FileOutputStream("D:\\FileIO\\New folder - Copy\\A - Copy (3).txt");
	foc=fos.getChannel();
	ByteBuffer vf = ByteBuffer.allocate(128);
	vf.asCharBuffer().put("This is how complex".toCharArray());
	foc.write(vf);
	foc.close();
	fis = new FileInputStream("D:\\FileIO\\New folder - Copy\\A - Copy (3).txt");
	fic = fis.getChannel();
	bf.clear();
	bf.allocate(fis.available());
	fic.read(bf);
	bf.flip();
	System.out.println("ChannelBufferTest.main(3)"+bf.asCharBuffer());
		

	}
	
	

}
