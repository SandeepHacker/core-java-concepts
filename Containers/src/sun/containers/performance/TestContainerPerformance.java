package sun.containers.performance;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class TestContainerPerformance<C> {
	
	C container;
	public TestContainerPerformance(C c) {
	this.container=c;
	}
	
	
	public C getC() {
		return container;
	}


	<T>void test(List<TestParams> methodName, int size){
		long start=0L;
		C c=container;
		System.out.println("=============================="+c.getClass().getName()+"=========================");
		Method [] methods = c.getClass().getMethods();
		for(TestParams method:methodName){
		for(Method m1 : methods ){			
			if(m1.getName().equals(method.name) && method.args.length==m1.getParameterCount()){
				System.out.println(m1.getName());
				try{
			start=internalMethodTest(m1, size, c, method.args);
				}
				catch(IllegalArgumentException arg){
					System.out.println("Wrong parameters arguments for method "+m1.getName());
				}
				catch(InvocationTargetException ite){
					System.out.println(c.getClass().getName()+" underlying "+m1.getName()+" method throws Exception ::"+ite.getCause());
				}
				catch(Exception e){
					e.printStackTrace();
				}
			break;
			}	
		}
		
System.out.println(start);
	}
	}
	
	long internalMethodTest(Method method,int size, Object obj, Object... args) throws Exception{
		method.setAccessible(true);
		long start= System.currentTimeMillis();
		for(int i=0;i<size;i++){					
				method.invoke(obj, args);

	}
		long	end= System.currentTimeMillis();
		return end-start;

}
}