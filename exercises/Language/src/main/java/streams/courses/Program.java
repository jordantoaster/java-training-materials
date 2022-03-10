package streams.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static streams.courses.CourseType.*;
import static java.util.Arrays.asList;

public class Program {

    public static void main(String[] args) {
        titlesOfCourses(buildData().stream());
        titlesOfCoursesWithoutATrainer(buildData().stream());
        namesAndRatesOfTrainers(buildData().stream());
        //This one has many possible solutions, so don't stop at just one :-)
        totalDurationsOfBeginnerAndNonBeginnerCourses(buildData());
        everyPairOfTrainersThatCouldDeliverJava(buildData());
        possibleCostsOfJeeWebDevelopment(buildData());
        coursesIdsAndTitlesGroupedByType(buildData().stream());
    }

    private static void titlesOfCourses(Stream<Course> courses) {
        System.out.println("The titles of all the courses are:");
        System.out.println("\t--- Your Solution Here ---");
    }

    private static void titlesOfCoursesWithoutATrainer(Stream<Course> courses) {
        System.out.println("The titles of all the courses without a trainer are:");
        System.out.println("\t--- Your Solution Here ---");
    }

    private static void namesAndRatesOfTrainers(Stream<Course> courses) {
        System.out.println("The names and rates of all trainers are:");
        System.out.println("\t--- Your Solution Here ---");
    }

    private static void totalDurationsOfBeginnerAndNonBeginnerCourses(List<Course> courses) {
        System.out.println("Total course durations are:");
        System.out.println("\t--- Your Solution Here ---");
    }

    private static void everyPairOfTrainersThatCouldDeliverJava(List<Course> courses) {
        System.out.println("Every pair of trainers that could deliver Java:");
        System.out.println("\t--- Your Solution Here ---");
    }

    private static void possibleCostsOfJeeWebDevelopment(List<Course> buildData) {
        System.out.println("Possible costs of 'JEE Web Development'");
        System.out.println("\t--- Your Solution Here ---");
    }

    private static void coursesIdsAndTitlesGroupedByType(Stream<Course> courses) {
        System.out.println("Course id's and titles grouped by type are:");
        System.out.println("\t--- Your Solution Here ---");
    }

    private static List<Course> buildData() {
        List<Course> courses = new ArrayList<Course>();
        Trainer jane = new Trainer("Jane Smith", 750.0, asList("SQL", "Java", "JEE"));
        Trainer pete = new Trainer("Pete Hughes", 1000.0, asList("Java", "JEE", "C#", "Scala"));
        Trainer mary = new Trainer("Mary Donaghy", 1250.0, asList("Java", "JEE", "C#", "C++"));
        courses.add(new Course("AB12", "Intro to Scala", BEGINNER, 4, asList(pete)));
        courses.add(new Course("CD34", "JEE Web Development", INTERMEDIATE, 3, asList(pete, mary, jane)));
        courses.add(new Course("EF56", "Meta-Programming in Ruby", ADVANCED, 2, asList()));
        courses.add(new Course("GH78", "OO Design with UML", BEGINNER, 3, asList(jane, pete, mary)));
        courses.add(new Course("IJ90", "Database Access with JPA", INTERMEDIATE, 3, asList(jane)));
        courses.add(new Course("KL12", "Design Patterns in C#", ADVANCED, 2, asList(pete, mary)));
        courses.add(new Course("MN34", "Relational Database Design", BEGINNER, 4, asList(jane)));
        courses.add(new Course("OP56", "Writing MySql Stored Procedures", INTERMEDIATE, 1, asList(jane)));
        courses.add(new Course("QR78", "Patterns of Parallel Programming", ADVANCED, 2, asList(pete, mary)));
        courses.add(new Course("ST90", "C++ Programming for Beginners", BEGINNER, 5, asList(mary)));
        courses.add(new Course("UV12", "UNIX Threading with PThreads", INTERMEDIATE, 2, asList()));
        courses.add(new Course("WX34", "Writing Linux Device Drivers", ADVANCED, 3, asList(mary)));

        return courses;
    }

}
