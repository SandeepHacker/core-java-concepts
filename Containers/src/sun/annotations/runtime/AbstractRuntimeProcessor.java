package sun.annotations.runtime;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractRuntimeProcessor {

	static String classpath = System.getProperty("java.class.path").split(";")[0];
	List<Class<?>> qclasses = new ArrayList<Class<?>>();

	protected Class<? extends Annotation> annotations;

	public AbstractRuntimeProcessor(Class<? extends Annotation> clazz) {
		annotations = clazz;
	}

	private void init() {

		try {
			getAllQualifiedClassNames(new File(classpath));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private Set<Class<?>> findAnnotatedClasses(Class<? extends Annotation> clazz) {
		List<Class<?>> temp = new ArrayList<Class<?>>();
		temp.addAll(qclasses);
		Set<Class<?>> result = new HashSet<Class<?>>();
		ElementType[] et = clazz.getDeclaredAnnotation(Target.class).value();

		for (ElementType e : et) {
			switch (e) {
			case TYPE:
				for (Class<?> c : temp)
					if (c.isAnnotationPresent(clazz))
						process(clazz);

				temp.removeAll(result);
				break;
			case METHOD:
				for (Class<?> c : temp)
					if (c.getDeclaredMethods().length > 0)
						for (Method m : c.getDeclaredMethods())
							if (m.isAnnotationPresent(clazz))
								processMethod(m);

				temp.removeAll(result);
				break;
			case CONSTRUCTOR:
				for (Class<?> c : temp)
					if (c.getDeclaredConstructors().length > 0)
						for (Constructor m : c.getDeclaredConstructors())
							if (m.isAnnotationPresent(clazz))
								processConstructor(m);

				temp.removeAll(result);

			}

		}
		return result;
	}

	private void getAllQualifiedClassNames(File f) throws ClassNotFoundException {
		File[] farr = f.listFiles();
		for (File f1 : farr) {
			String path = null;
			if (f1.isDirectory())
				getAllQualifiedClassNames(f1);
			else {
				path = f1.getAbsolutePath();
				path = path.substring(classpath.length() + 1, path.lastIndexOf("."));
				path = path.replace("\\", ".");
			}
			if (path != null)
				qclasses.add(Class.forName(path));
		}
	}

	public void processAnnotations() {
		init();
		for (Class<?> clazz : findAnnotatedClasses(annotations)) {
			process(clazz);
		}

	}

	protected void process(Class<?> clazz) {

	}

	protected void processMethod(Method method) {

	}

	protected void processConstructor(Constructor<?> constructor) {

	}

}
