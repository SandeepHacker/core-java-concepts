package sun.io.readwrite;

import java.io.IOException;
import java.util.ArrayList;

public class TestOperations {
	public static void main(String[] args) throws IOException {
/*		System.out.println(ReadFile.read("D:\\FileIO\\New folder - Copy\\A - Copy (1).txt"));
		System.out.println(ReadFile.readBytes("D:\\FileIO\\New folder - Copy\\A - Copy (1).txt"));
		System.out.println(ReadFile.readBytes_v2("D:\\FileIO\\New folder - Copy\\A - Copy (1).txt"));
		System.out.println(ReadFile.readReverse("D:\\FileIO\\New folder - Copy\\A - Copy (1).txt"));
		ReadFile.readOneCharacter("D:\\FileIO\\New folder - Copy\\A - Copy (1).txt");*/
//		System.out.println(ReadFile.readOneCharacter("D:\\FileIO\\New folder - Copy\\img045.jpg"));
		
//		WriteFile.write("D:\\FileIO\\New folder - Copy\\A - Copy (1).txt", "D:\\FileIO\\New folder - Copy\\A - Copy (2).txt");
		System.out.println("TestOperations.main()"+ReadFile.readByCharacterCount("D:\\FileIO\\New folder - Copy\\A - Copy (1).txt"));
	System.out.println(ReadFile.readBySplit("D:\\FileIO\\New folder - Copy\\A - Copy (1).txt", " "));
	
	WriteFile.writeBinary("D:\\FileIO\\New folder - Copy\\img045.jpg", "D:\\FileIO\\New folder - Copy\\monapan.jpg");
	}
}
