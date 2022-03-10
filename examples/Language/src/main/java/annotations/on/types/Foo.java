package annotations.on.types;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({TYPE_USE })
@Retention(RUNTIME)
public @interface Foo { 
}
