package sun.containers.performance;

import java.util.ArrayList;
import java.util.List;








import sun.containers.array.filler.Generator;
import sun.containers.array.filler.SerialGenerator;
import sun.containers.fillers.ContainerGenerator;

public class TestRunner{
	
	private static TestLoader loader;

	public TestRunner(TestLoader loader) {
	this.loader = loader;
}

	public static <C> long executeTypeTests(Class<C> c,Test<C> test,int size,int loops) throws Exception{
		System.out.println("================="+c.getName()+"============================");
		System.out.println("================="+test.testName()+"============================");
					long totalTime=0L;
					for(int i=0;i<loops;i++){
						C type = c.newInstance();
						long start=System.currentTimeMillis();
					test.test(type, size);
					long end=System.currentTimeMillis();
					totalTime += (end-start);
					}
					
					return totalTime;

	}
	
	@SuppressWarnings("unchecked")
	public <C> void executeAllTests(C container,List<Test<C>> test,int size,int loops) throws Exception{
		int testNo=1;
	
					for(Test<C> t:test){ 
						long totalTime = 0L;
					for(int i=0;i<loops;i++){
						long start=System.currentTimeMillis();
						t.test(container, size);
					long end=System.currentTimeMillis();
					totalTime += (end-start);
					}
					System.out.println("TestNo = "+testNo+" ::: TestName = " +t.getClass().getSimpleName()+" === "+totalTime);
					}
	}
	
	@SuppressWarnings("unchecked")
	public <C> void executeAllTests(Class<C> clazz,List<Test<C>> test,int size,int loops) throws Exception{
C container;
		int testNo=0;
		System.out.println(clazz.getSimpleName());
					for(Test<C> t:test){
						testNo++;
						if(!t.getClass().getSimpleName().equalsIgnoreCase("add"))
							container =  (C) ContainerGenerator.loadContainer(clazz, loader.getGen(), size);
						else
							container=(C) clazz.newInstance();
						
						
						long totalTime = 0L;
					for(int i=0;i<loops;i++){
						long start=System.currentTimeMillis();
						t.test(container, size);
					long end=System.currentTimeMillis();
					totalTime += (end-start);
					}
					System.out.println("TestNo = "+testNo+" ::: TestName = " +t.getClass().getSimpleName()+" === "+totalTime);
					}
	}
	
	@SuppressWarnings("unchecked")
	public static <C> void executeAllTestsUpdated(Class<C> clazz,List<Test<C>> list) throws Exception{
C container=null;
		int testNo=0;
		System.out.println(clazz.getSimpleName()+" Size:::::"+loader.getSize());
		if(list.isEmpty())
			throw new RuntimeException("No TestCase with class name :: "+clazz.getSimpleName()+"Test  found");
					for(Test<C> t:list){
						testNo++;
					
						long totalTime = 0L;
	
					for(int i=0;i<loader.getLoops();i++){
						try{
						if(t.getClass().getSimpleName().equalsIgnoreCase("add") || t.getClass().getSimpleName().equalsIgnoreCase("put"))
							
							container = (C)clazz.newInstance();
						else{

						if(container==null)
							container =  (C) ContainerGenerator.loadContainer(clazz, loader.getGen(), loader.getSize());
						}
						}
						catch(Exception e){
							throw new RuntimeException("Container Loading Failed",e);
						}
						
					
						long start=System.currentTimeMillis();
						t.test(container, loader.getSize());
					long end=System.currentTimeMillis();
					totalTime += (end-start);
					}
					System.out.println("TestNo = "+testNo+" ::: TestName = " +t.getClass().getSimpleName()+" === "+totalTime);
					}
	}
	
	static <E, C>void runPerformanceTest(Generator<E> gen, int size, int loops, Class<C> clazz, String className) throws Exception{
		loader=new TestLoader<E, C>(gen, size, loops);
		executeAllTestsUpdated(clazz,loader.loadTests(className));
	}

	static <E, C>void runPerformanceTest(TestParameters<E>  params, Class<C> clazz) throws Exception{
		loader=new TestLoader<E, C>(params.getGen(), params.getSize(), params.getLoops());
		executeAllTestsUpdated(clazz,loader.loadTests(params.getTestClassName()));
	}


}
