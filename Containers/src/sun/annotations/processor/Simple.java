package sun.annotations.processor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.PACKAGE,ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.LOCAL_VARIABLE,
	ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
public @interface Simple {

	String value() default "-1";
}
