package sun.annotations.runtime;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAnnotationProcessor extends AbstractRuntimeProcessor {

	
	public TestAnnotationProcessor(Class<? extends Annotation> clazz) {
		super(clazz);
	}
		
	@Override
	public void processMethod(Method method) {
		try {
			method.invoke(method.getDeclaringClass().newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

}
