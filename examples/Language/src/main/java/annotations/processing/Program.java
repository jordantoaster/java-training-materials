package annotations.processing;

import java.util.Set;

import javax.annotation.processing.*;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import static javax.lang.model.SourceVersion.RELEASE_6; 
import static javax.tools.Diagnostic.Kind.NOTE;

/*
 * To use this annotation processor open a shell / console in the folder 'test/ap' and run the compiler as follows:
 *  'javac -cp ../../bin -processor annotations.processing.NumericOperators *.java'
 *  
 *  You should get the following output:
 *  
 *  Note: NumericOperators called!
 *  Found annotations.processing.FooBar while processing the following types:
 *	    MyClass
 *	    OtherClass
 *  The annotated ones were:
 *	    MyClass
 */

@SupportedAnnotationTypes("annotations.processing.FooBar")
@SupportedSourceVersion(RELEASE_6)
public class Program extends AbstractProcessor {
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		if (!roundEnv.processingOver()) {
			processingEnv.getMessager().printMessage(NOTE, "NumericOperators called!");
			for(TypeElement te : annotations) {
				System.out.printf("Found %s while processing the following types:\n",te.getQualifiedName());
				for(Element e : roundEnv.getRootElements()) {
					System.out.printf("\t%s\n",e.getSimpleName());
				}
				System.out.println("The annotated ones were:");
				for(Element e : roundEnv.getElementsAnnotatedWith(te)) {
					System.out.printf("\t%s\n",e.getSimpleName());
				}
			}
		}
		return true;
	}
}

