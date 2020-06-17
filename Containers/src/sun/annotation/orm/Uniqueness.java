package sun.annotation.orm;

public @interface Uniqueness {
Constraints constraints() default @Constraints(unique=true);
}
