package sun.containers.set;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class SetFiller {

	
	static <T> void fill(Set<T> set, Class<T> type,int size) throws Exception{
		for(int i=1;i<=size;i++)
			set.add(type.getConstructor(int.class).newInstance(i));
	}
	
}
