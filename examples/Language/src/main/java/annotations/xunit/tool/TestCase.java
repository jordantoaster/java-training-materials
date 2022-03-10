package annotations.xunit.tool;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestCase {
	String value() default "Anonymous";
}
