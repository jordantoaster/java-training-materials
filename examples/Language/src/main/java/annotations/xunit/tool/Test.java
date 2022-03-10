package annotations.xunit.tool;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
	int order() default 0;
	boolean ignore() default false;
}
