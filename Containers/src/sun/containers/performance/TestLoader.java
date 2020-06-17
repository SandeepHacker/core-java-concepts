package sun.containers.performance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sun.containers.array.filler.ArrayGenerator;
import sun.containers.array.filler.Generator;

public class TestLoader<E,C> {

	private Generator<E> gen;

	private int size;
	private int loops;
	private List<Test<C>> allTests = new ArrayList<Test<C>>() ;
	private final TestCase<E> testCases;
	public TestLoader(Generator<E> gen, int size, int loops) {
		this.gen = gen;
		this.size = size;
		this.loops = loops;
		testCases = new TestCase<E>(ArrayGenerator.fillArray(gen.next().getClass(), gen, size));
	}
	
	

	public Generator<E> getGen() {
		return gen;
	}
	public int getSize() {
		return size;
	}
	public int getLoops() {
		return loops;
	}

	public List<Test<C>> loadTests(String className){
//		String className = clazz.getSimpleName().concat("Test");

		Class<?>[] testClasses  = testCases.getClass().getClasses();

		for(Class<?> test :testClasses){
			if(className.equals(test.getSimpleName())){
				try {
				Object testClassInstance = test.getDeclaredConstructor(testCases.getClass()).newInstance(testCases);
				Class<?>[] testNames =test.getClasses();
				for(Class<?> t: testNames){

						allTests.add((Test<C>) t.getConstructor(test).newInstance(testClassInstance));
					
				}
				} catch (Exception e) {
					throw new RuntimeException("Error while creating Test class", e);
				} 
			}
		}
		return allTests;
	}
	
	


}
