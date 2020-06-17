package sun.containers.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class RunTests {
	
	public static void main(String[] args) {
		TestContainerPerformance<ArrayList<String>> c = new TestContainerPerformance<ArrayList<String>>(new ArrayList<String>());
		TestContainerPerformance<LinkedList<String>> c1 = new TestContainerPerformance<LinkedList<String>>(new LinkedList<String>());
		TestContainerPerformance<Vector<String>> v = new TestContainerPerformance<Vector<String>>(new Vector<String>());
ArrayList<TestParams> al = new ArrayList<TestParams>();
LinkedList<String> al1 = new LinkedList<String>();
al1.add("Sun");
al1.add("Moon");
al.add(new TestParams("add",new Object[]{"Great!"} ));
al.add(new TestParams("addAll",new Object[]{al1} ));
al.add(new TestParams("get", new Integer[]{4455}));
al.add(new TestParams("set", new Object[]{4375,"Don"}));
al.add(new TestParams("contains", new Object[]{"Don"}));
al.add(new TestParams("indexOf", new Object[]{"Don"}));
		c.test(al,100000);
		c1.test(al,100000);
		v.test(al,100000);

	}

}
