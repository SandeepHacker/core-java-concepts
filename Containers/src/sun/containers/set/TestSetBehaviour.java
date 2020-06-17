package sun.containers.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestSetBehaviour {
	
	
	
	
	public static void main(String[] args) throws Exception {
	test(new HashSet())	;//Element,SetElement wont work
	test(new LinkedHashSet());//Element,SetElement wont work
	test(new TreeSet());//Only TreeSetElement will work i.e those classes which implements Comparable will only work with TreeSet
	}
	
	
	@SuppressWarnings("unchecked")
	static void test(Set set) throws Exception{
		List<Class> list = Arrays.asList(Element.class,SetElement.class,HashSetElement.class,TreeSetElement.class);
		System.out.println("====================="+set.getClass().getSimpleName()+"========================");
		for(Class clz:list){
		System.out.println(clz.getSimpleName());
		System.out.println("=====================");
		try{
		SetFiller.fill(set, clz, 5);
		System.out.println(set);
		SetFiller.fill(set, clz, 5);
		System.out.println(set);
		SetFiller.fill(set, clz, 5);
		System.out.println(set);
		}
		catch(Exception e){
			System.out.println(clz.getSimpleName()+" wont work with "+set.getClass().getSimpleName());
		}
		set.clear();
		}
	}
	
	
	

}
