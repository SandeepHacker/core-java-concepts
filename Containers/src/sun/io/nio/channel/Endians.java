package sun.io.nio.channel;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Arrays;

public class Endians {
	
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(12);
		bb.asCharBuffer().put("abcdef".toCharArray());
		
		System.out.println("Endians.main()"+Arrays.toString(bb.array()));
		bb.rewind();
		bb.order(ByteOrder.BIG_ENDIAN);
		bb.asCharBuffer().put("abcdef".toCharArray());
		System.out.println("Endians.main()"+Arrays.toString(bb.array()));
		bb.rewind();	
		bb.order(ByteOrder.LITTLE_ENDIAN);
		bb.asCharBuffer().put("abcdef".toCharArray());
		System.out.println("Endians.main()"+Arrays.toString(bb.array()));
		
	}

}
