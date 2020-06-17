package sun.io.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.FileChannel;
import java.time.LocalDateTime;
import java.util.Collections;
/*A particularly clever aspect of object serialization is that it not only saves an image of your
object, but it also follows all the references contained in your object and saves those objects,
and follows all the references in each of those objects, etc. This is sometimes referred to as the 
"web of objects" that a single object can be connected to, 
and it includes arrays of
references to objects as well as member objects.*/
public class PerformSerializationAndDeserialization {
	
	
	/*Note that no constructor, not even the default constructor, is called in the process of
	deserializing a Serializable object. The entire object is restored by recovering data from the
	InputStream.*/
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		complexSerialization();
		
//		simpleSerialization();
//		simpleExternalization();
//		customExternalization();
//		transientKeywordSerialiazation();
		alteranateToExternaliazation();
	}
	
	static void complexSerialization() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
		Worm w = new Worm(24,'a');
		oos.writeObject(w);
		System.out.println(w+"\nObject Serialized");
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
		Worm d1 = (Worm) ois.readObject();
		ois.close();
		System.out.println("Deserialized Successfully\n"+d1);
	}
	
	
	static void simpleSerialization() throws FileNotFoundException, IOException, ClassNotFoundException{
		//Simple Serialization
		
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
				Data d = new Data(29);
				Blip3 v = new Blip3();
				oos.writeObject(v);
				System.out.println("Object Serialized");
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
//				Data d1 = (Data) ois.readObject();
				Blip3 d2 = (Blip3) ois.readObject();
			
				System.out.println("Deserialized Successfully\n"+d2);
	}
	
	/*When blip1 is recovered, the Blip1 default constructor is called. This is different from
	recovering a Serializable object, in which the object is constructed entirely from its stored
	bits, with no constructor calls. With an Externalizable object, all the normal default
	construction behavior occurs (including the initializations at the point of field definition),
	and then readExternal( ) is called. You need to be aware of this—in particular, the fact that
	all the default construction always takes place—to produce the correct behavior in your
	Externalizable objects.
	If you see Blip2 and Blip3 are exactly same and except Blip2 implements Externalizable and Blip3 implements Serializable  and if we serialize both and deserialize
	we cannot deserialize Blip2 as it's constructor is not public but in case of Blip3 we can deserialize because it doesn't need to call constructors.
	NOTE:::: in Externalization the ordering of writing and reading objects should be same*/
	static void simpleExternalization() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
		Blip1 d = new Blip1();
		oos.writeObject(d);
		System.out.println("Object Serialized");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
		Blip1 d1 = (Blip1) ois.readObject();
		
		System.out.println("Deserialized Successfully\n"+d1);
		
		/*ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
		Blip2 d2 = new Blip2();
		oos1.writeObject(d2);
		System.out.println("Object Serialized");
		ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
		Blip2 d3 = (Blip2) ois1.readObject();
		
		System.out.println("Deserialized Successfully\n"+d3);*/
	}

	static void customExternalization() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
		Blip4 d = new Blip4(2,"A");
		oos.writeObject(d);
		System.out.println("Object Serialized");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
		Blip4 d1 = (Blip4) ois.readObject();
		
		System.out.println("Deserialized Successfully\n"+d1);
		

	}
	
	
	static void transientKeywordSerialiazation() throws IOException, ClassNotFoundException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
		Logon logon = new Logon("sandeep143", "143Sandeep");
		oos.writeObject(logon);
		System.out.println("Object Serialized");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
		Logon d1 = (Logon) ois.readObject();
		System.out.println("Deserialized Object at "+LocalDateTime.now());
		System.out.println("Deserialized Successfully\n"+d1);
	}
	/*If you’re not keen on implementing the Externalizable interface, there’s another approach.
	You can implement the Serializable interface and add (notice I say "add" and not
	"override" or "implement") methods called writeObject( ) and readObject( ) that will
	automatically be called when the object is serialized and deserialized, respectively. That is, if
	you provide these two methods, they will be used instead of the default serialization.
	There’s one other twist. Inside your writeObject( ), you can choose to perform the default
writeObject( ) action by calling defaultWriteObject( ). Likewise, inside readObject( )
you can call defaultReadObject( ). Here is a simple example that demonstrates how you
can control the storage and retrieval of a Serializable object: This is the best approach for custom Serialization*/
	static void alteranateToExternaliazation() throws IOException, ClassNotFoundException{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
		Scoreboard scoreboard = new Scoreboard(98,3,11,9,2);
		oos.writeObject(scoreboard);
		System.out.println("Object Serialized");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\FileIO\\New folder - Copy\\A - Copy (4).txt"));
		Scoreboard d1 = (Scoreboard) ois.readObject();
		System.out.println("Deserialized Successfully\n"+d1);
	}
}
