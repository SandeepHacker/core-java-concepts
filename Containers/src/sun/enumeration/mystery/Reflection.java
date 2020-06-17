package sun.enumeration.mystery;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import sun.io.standard.ProcessControl;

public class Reflection {
	
	
	static Set<String> analyze(Class<?> clazz){
		System.out.println(clazz.getSimpleName()+"\n================================");
		Set<String> methodNames = new HashSet<String>();
		System.out.println("Interfaces::");
	Arrays.toString(clazz.getInterfaces());
	System.out.println("Methods::"+clazz.getMethods().length);
	Method[] methods = clazz.getMethods();
for(Method m : methods){
	m.setAccessible(true);
	methodNames.add(m.getName());
}
	System.out.println("Superclass::");
	System.out.println(clazz.getSuperclass());
		
		return methodNames;
	}
	
	public static void main(String[] args) throws Exception {
		Set<String> exploreEnum = analyze(Explore.class);
		Set<String> parentEnum = analyze(Enum.class);
		System.out.println(exploreEnum.size());
		System.out.println(exploreEnum.removeAll(parentEnum));
		System.out.println(exploreEnum.size());
		ProcessControl.process("javap","Explore");
	}

}
