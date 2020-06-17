package sun.io.nio.channel;

import java.nio.charset.Charset;

public class AvailaibleCharsets {

	
	public static void main(String[] args) {
		System.out.println("AvailaibleCharsets.main()"+Charset.availableCharsets().keySet());
	}
	
}
