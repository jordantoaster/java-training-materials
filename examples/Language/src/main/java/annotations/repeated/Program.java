package annotations.repeated;

import java.lang.annotation.Annotation;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Program {
    public static void main(String[] args) {
        Class<Employee> klass = Employee.class;
        printOwners(klass);
    }

    private static void printOwners(Class<?> klass) {
        Stream<Annotation> notes = asList(klass.getAnnotations()).stream();
        Optional<Annotation> option = notes.filter(a -> a.annotationType() == Maintainers.class).findFirst();
        if (option.isPresent()) {
            option.ifPresent(Program::listOwners);
        } else {
            System.out.println("This class has no owners!");
        }
    }

    private static void listOwners(Annotation note) {
        if (!(note instanceof Maintainers)) {
            throw new IllegalArgumentException("Argument not of expected type");
        }
        System.out.println("This class is owned by:");
        Maintainers maintainers = (Maintainers) note;
        for (Owner owner : maintainers.value()) {
            System.out.printf("\t%s\n", owner.value());
        }
    }
}
