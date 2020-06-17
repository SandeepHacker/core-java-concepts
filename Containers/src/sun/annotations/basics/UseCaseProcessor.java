package sun.annotations.basics;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UseCaseProcessor {

	
	public static void trackUseCasesCovered(List<Integer>useCases, Class<?> clazz){
		Method [] m = clazz.getDeclaredMethods();
		for(Method m1 : m){
			UseCase uc = m1.getDeclaredAnnotation(UseCase.class);
			if(uc!=null){
				System.out.println("Found UseCases ................"+uc.id()+"----------"+uc.description());
				useCases.remove(new Integer(uc.id()));
			}

		}
		for(int i : useCases){
			System.out.println("UseCase Missing......"+i);
		}
	}
	
	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases, 45,47, 48, 49, 50);
		trackUseCasesCovered(useCases, PasswordPolicyUseCases.class);
	    String classpath = System.getProperty("java.class.path");
	    System.out.println(classpath);
        String javaHome = System.getProperty("java.home");
        System.out.println(javaHome);
//        classpath.replace("\\", "\\\\");
        classpath=classpath.split(";")[0];
        System.out.println(classpath);
        File f = new File(classpath);


   
       
	}
	
	
	
	
	
}
