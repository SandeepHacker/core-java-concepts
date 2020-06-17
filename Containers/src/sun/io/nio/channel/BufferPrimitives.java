package sun.io.nio.channel;

import java.nio.ByteBuffer;

public class BufferPrimitives {
	
	
	private static final int BSIZE = 1024;
	public static void main(String[] args) {
	ByteBuffer bb = ByteBuffer.allocate(BSIZE);
	// Allocation automatically zeroes the ByteBuffer:
	int i = 0;
	while(i++ < bb.limit())
	if(bb.get() != 0)
	System.out.print("nonzero");
	System.out.print("i = " + i);
	bb.rewind();
	// Store and read a char array:
	bb.asCharBuffer().put("Howdy!");
	char c;
	while((c = bb.getChar()) != 0)
		System.out.print(c + " ");

	bb.rewind();
	// Store and read a short:
	bb.asShortBuffer().put((short)471142);
	System.out.print(bb.getShort());
	bb.rewind();
	// Store and read an int:
	bb.asIntBuffer().put(99471142);
	System.out.print(bb.getInt());
	bb.rewind();
	// Store and read a long:
	bb.asLongBuffer().put(99471142);
	System.out.print(bb.getLong());
	bb.rewind();
	// Store and read a float:
	bb.asFloatBuffer().put(99471142);
	System.out.print(bb.getFloat());
	bb.rewind();
	// Store and read a double:
	bb.asDoubleBuffer().put(99471142);
	System.out.print(bb.getDouble());
	bb.rewind();
	}

}
