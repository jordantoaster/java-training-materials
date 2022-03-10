package annotations.and.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

public class Program {
    public static void main(String[] args) throws Exception {
        //Load the class and obtain the Class instance
        Class<?> klass = Class.forName("annotations.and.reflection.Demo");
        //Iterate over all the methods of the type
        for(Method method : klass.getDeclaredMethods()) {
            System.out.println("Looking at: " + method.getName());
            //Iterate over all the Type Parameters specific to this method
            for(TypeVariable<Method> parameter : method.getTypeParameters()) {
                //Iterate over all the annotations specific to this Type Parameter
                for (Annotation annotation : parameter.getDeclaredAnnotations()) {
                    //Test if the current annotation is the one we are looking for
                    if (annotation.annotationType() == Foobar.class) {
                        Foobar foobar = parameter.getAnnotation(Foobar.class);
                        System.out.printf("\tThis method is annotated with elements:\n");
                        System.out.printf("\t\t value = %s \n", foobar.value());
                        System.out.printf("\t\t other = %s \n", foobar.other());
                    }
                }
            }
        }
    }
}
