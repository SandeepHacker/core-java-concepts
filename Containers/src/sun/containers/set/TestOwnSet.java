package sun.containers.set;

import java.util.ArrayList;
import java.util.HashSet;

import sun.containers.own.ClassicSet;

public class TestOwnSet {
	
	public static void main(String[] args) {
		ClassicSet<String> set = new ClassicSet<String>();
		set.add("Sandeep");
		set.add("Sandee");
		set.add("Sande");
		set.add("Sandeep");
		
		System.out.println("TestOwnSet.main()"+set);
		set.remove("Sande");
		System.out.println("TestOwnSet.main()"+set);
set.clear();
System.out.println("TestOwnSet.main()"+set);
ArrayList<String> al = new ArrayList<String>();
al.add("Sandeep");
al.add("Sandee");

al.add("Sande");
al.add("Sandeep");
System.out.println("TestOwnSet.main()"+al);
al.remove(2);
System.out.println("TestOwnSet.main()"+al);

	}

}
