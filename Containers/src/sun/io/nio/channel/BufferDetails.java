package sun.io.nio.channel;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;

public class BufferDetails {
	/*mark() should be always used with reset() 
	 * mark() Sets this buffer's mark at its position.
		reset()
		Resets this buffer's position to the previously-marked position.
		Invoking this method neither changes nor discards the mark's value.
	Throws:
	InvalidMarkException - If the mark has not been set*/
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(128);
		bb.asCharBuffer().put("I was doing fine before I met you");
		System.out.println(bb.mark());

		System.out.println(bb.capacity());
	
			System.out.println(bb.position());
			
		System.out.println(bb.limit());
		
		symmetricScramble(bb.asCharBuffer());
		symmetricScramble(bb.asCharBuffer());
	}
	
	public static  void symmetricScramble(CharBuffer cb){
	
		while(cb.hasRemaining()){
			cb.mark();
			char c1 = cb.get();
			char c2 = cb.get();
			cb.reset();
			cb.put(c2);
			cb.put(c1);
		
		}
		
	cb.rewind();
	while(cb.hasRemaining()){
		System.out.print(cb.get());
	}
	}

}
