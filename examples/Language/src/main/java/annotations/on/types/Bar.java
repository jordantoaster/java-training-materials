package annotations.on.types;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({TYPE_PARAMETER })
@Retention(RUNTIME)
public @interface Bar {   
}
