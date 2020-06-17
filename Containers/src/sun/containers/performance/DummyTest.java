package sun.containers.performance;

import java.util.ArrayList;

public class DummyTest implements Test<ArrayList<String>>{

	@Override
	public void test(ArrayList<String> test, int size) {
	for(int i=0;i<size;i++)
		test.add("Sun");
	System.out.println("DummyTest.test()"+test);
	}



}
