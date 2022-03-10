package streams.courses;

import util.Pair;

import java.util.*;
import java.util.stream.Stream;

import static streams.courses.CourseType.*;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;

public class Solution {
    public static void main(String[] args) {
        titlesOfCourses(buildData().stream());
        titlesOfCoursesWithoutATrainer(buildData().stream());
        namesAndRatesOfTrainers(buildData().stream());
        totalDurationsOfBeginnerAndNonBeginnerCoursesV1(buildData());
        totalDurationsOfBeginnerAndNonBeginnerCoursesV2(buildData().stream());
        totalDurationsOfBeginnerAndNonBeginnerCoursesV3(buildData());
        totalDurationsOfBeginnerAndNonBeginnerCoursesV4(buildData().stream());
        everyPairOfTrainersThatCouldDeliverJava(buildData());
        possibleCostsOfJeeWebDevelopment(buildData());
        coursesIdsAndTitlesGroupedByType(buildData().stream());
    }

    private static void titlesOfCourses(Stream<Course> courses) {
        System.out.println("The titles of all the courses are:");
        courses.map(Course::getTitle)
                .forEach(Solution::printTabbed);
    }

    private static void titlesOfCoursesWithoutATrainer(Stream<Course> courses) {
        System.out.println("The titles of all the courses without a trainer are:");
        courses.filter(c -> c.getInstructors().isEmpty())
                .map(Course::getTitle)
                .forEach(Solution::printTabbed);
    }

    private static void namesAndRatesOfTrainers(Stream<Course> courses) {
        System.out.println("The names and rates of all trainers are:");
        courses.flatMap(c -> c.getInstructors().stream())
                .distinct()
                .map(t -> new Pair<>(t.getName(), t.getRate()))
                .forEach(Solution::printTabbed);
    }

    private static void totalDurationsOfBeginnerAndNonBeginnerCoursesV1(List<Course> courses) {
        System.out.println("Attempt 1: Total course durations are:");
        totalDurationOfBeginnerCourses(courses.stream());
        totalDurationOfNonBeginnerCourses(courses.stream());
    }

    private static void totalDurationOfBeginnerCourses(Stream<Course> courses) {
        int result = courses.filter(c -> c.getType() == BEGINNER)
                .mapToInt(Course::getDuration)
                .sum();
        System.out.println("\tTotal for beginners is: " + result);
    }

    private static void totalDurationOfNonBeginnerCourses(Stream<Course> courses) {
        int result = courses.filter(c -> c.getType() != BEGINNER)
                .mapToInt(Course::getDuration)
                .sum();
        System.out.println("\tTotal for non-beginners is: " + result);
    }

    private static void totalDurationsOfBeginnerAndNonBeginnerCoursesV2(Stream<Course> courses) {
        Pair<Integer, Integer> result = courses.reduce(new Pair<Integer, Integer>(0, 0), Solution::totalDurations, (a, b) -> null);
        System.out.println("Attempt 2: Total course durations are:");
        System.out.println("\tTotal for beginners is: " + result.getFirst());
        System.out.println("\tTotal for non-beginners is: " + result.getSecond());
    }

    private static Pair<Integer, Integer> totalDurations(Pair<Integer, Integer> total, Course course) {
        int totalBeginners = total.getFirst();
        int totalNonBeginners = total.getSecond();
        int duration = course.getDuration();
        if (course.getType() == BEGINNER) {
            return new Pair<>(totalBeginners + duration, totalNonBeginners);
        } else {
            return new Pair<>(totalBeginners, totalNonBeginners + duration);
        }
    }

    private static void totalDurationsOfBeginnerAndNonBeginnerCoursesV3(List<Course> courses) {
        int durationForBeginner = courses.stream()
                .filter(c -> c.getType() == BEGINNER)
                .mapToInt(Course::getDuration)
                .sum();
        int durationForNonBeginner = courses.stream()
                .filter(c -> c.getType() != BEGINNER)
                .mapToInt(Course::getDuration)
                .sum();

        System.out.println("Attempt 3: Total course durations are:");
        System.out.println("\tTotal for beginners is: " + durationForBeginner);
        System.out.println("\tTotal for non-beginners is: " + durationForNonBeginner);
    }

    private static void totalDurationsOfBeginnerAndNonBeginnerCoursesV4(Stream<Course> courses) {
        Map<Boolean, Integer> results = courses.collect(partitioningBy(c -> c.getType() == BEGINNER, summingInt(Course::getDuration)));
        System.out.println("Attempt 4: Total course durations are:");
        System.out.println("\tTotal for beginners is: " + results.get(true));
        System.out.println("\tTotal for non-beginners is: " + results.get(false));
    }

    private static void everyPairOfTrainersThatCouldDeliverJava(List<Course> courses) {
        class NamePair extends Pair<String,String> {
            public NamePair(String first, String second) {
                super(first, second);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                NamePair pair = (NamePair) o;
                if(getFirst().equals(pair.getFirst()) && getSecond().equals(pair.getSecond())) {
                    return true;
                }
                //allow pairs to be equal even if values are stored in a different order
                return getSecond().equals(pair.getFirst()) && getFirst().equals(pair.getSecond());
            }

            @Override
            public int hashCode() {
                return getFirst().hashCode() + getSecond().hashCode();
            }

        }

        System.out.println("Every pair of trainers that could deliver Java:");
        javaTrainers(courses).flatMap(t1 -> javaTrainers(courses).filter(t2 -> t1 != t2)
                .map(t2 -> new Pair<>(t1, t2)))
                .map(p -> new NamePair(p.getFirst().getName(), p.getSecond().getName()))
                .distinct()
                .forEach(Solution::printTabbed);
    }

    private static Stream<Trainer> javaTrainers(List<Course> courses) {
        return courses.stream()
                .flatMap(c -> c.getInstructors().stream())
                .distinct()
                .filter(t -> t.getSkills().contains("Java"));
    }

    private static void possibleCostsOfJeeWebDevelopment(List<Course> buildData) {
        System.out.println("Possible costs of 'JEE Web Development'");
        Optional<Course> selected = buildData.stream()
                .filter(c -> c.getTitle().equals("JEE Web Development"))
                .findFirst();

        String msg = "\t%s at a cost of %.2f\n";
        int duration = selected.map(Course::getDuration)
                .orElse(0);
        selected.ifPresent(c -> c.getInstructors()
                .forEach(t -> System.out.printf(msg, t.getName(), t.getRate() * duration)));
    }

    private static void coursesIdsAndTitlesGroupedByType(Stream<Course> courses) {
        System.out.println("Course id's and titles grouped by type are:");
        String msg = "\tCourses of type %s are %s\n";
        Map<CourseType, List<String>> coursesByType = courses.collect(groupingBy(Course::getType, mapping(Course::getTitle, toList())));
        coursesByType.forEach((key, values) -> System.out.printf(msg, key, values));
    }

    private static <T> void printTabbed(T input) {
        System.out.print("\t");
        System.out.println(input.toString());
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
