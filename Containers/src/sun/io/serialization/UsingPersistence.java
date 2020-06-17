package sun.io.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UsingPersistence {
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream br = new ByteArrayOutputStream();
		Division d = new Division("LightHeavyweight");
		
		Player p = new Player("Daniel Cormier",d);
		Player p1 = new Player("Rashad Evans",d);
		Player p2 = new Player("Dominick Reyes",d);
		Player p3 = new Player("Anthony Smith",d);
ArrayList<Player> l = new ArrayList<Player>();
		
l.add(p);l.add(p3);
l.add(p2);l.add(p1);
ArrayList<Player> l1 = new ArrayList<Player>(); 
l1.add(new Player("Jon Jones", d));

//Note here multiple output can act on one input stream if we use reset()
ObjectOutputStream oos = new ObjectOutputStream(br);
br.reset();
ObjectOutputStream oos1 = new ObjectOutputStream(br);
oos.writeObject(l);
oos1.writeObject(l1);
System.out.println("UsingPersistence.main()"+l);
oos.close();
ByteArrayInputStream br1 = new ByteArrayInputStream(br.toByteArray());
ObjectInputStream ois = new ObjectInputStream(br1);
System.out.println("UsingPersistence.main()"+ois.readObject());
System.out.println("UsingPersistence.main()"+ois.readObject());




	}

}
