package sun.containers.performance;

@FunctionalInterface
public interface Test<C> {
	
public void test(C test,int size);

default String testName(){
	return "TEST";
}
	
}
