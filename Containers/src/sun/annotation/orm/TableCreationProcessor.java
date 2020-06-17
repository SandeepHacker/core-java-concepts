package sun.annotation.orm;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TableCreationProcessor {
	
	public static void main(String[] args) {
//		System.out.println(createSQLQuery(Member.class));
	}

	
	
	public static String createSQLQuery(Class<?> annotatedClass){
		StringBuilder sb = new StringBuilder();
		
		DBTable db = annotatedClass.getDeclaredAnnotation(DBTable.class);
		
		sb.append("CREATE TABLE ").append(db.name().toUpperCase()).append("(");
		
		
		Field[] field = annotatedClass.getDeclaredFields();
		
		for(Field f :field){
			Annotation[] ann = f.getDeclaredAnnotations();
			
			for(Annotation an : ann){
				if(an instanceof SQLString){
					SQLString ss = (SQLString)an;
					sb.append(ss.name().toUpperCase()).append(" VARCHAR(").append(ss.value()).append(")");
					if(ss.constraints().primaryKey())
						sb.append(" PRIMARY KEY");
					
					sb.append(", ");
				}
				
				if(an instanceof SQLInteger){
					SQLInteger ss = (SQLInteger)an;
					sb.append(ss.name().toUpperCase()).append(" INT");
					
					sb.append(", ");
				}
	
			
			}
			System.out.println(sb.toString());
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(");");
		return sb.toString();
	}
	
	

}
