package classes;

import java.util.Arrays;

public class FpStudent {
    private String name;
    private String courseTitle;
    private int yearOfStudy;
    private double[] marks;

    public FpStudent(String name, String courseTitle, int yearOfStudy, double[] marks) {
        this.courseTitle = courseTitle;
        this.marks = marks;
        this.name = name;
        this.yearOfStudy = yearOfStudy;
    }

    public double average() {
        return Arrays.stream(marks)
                .average()
                .orElse(0.0);
    }

    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append(name);
        msg.append(" studying ");
        msg.append(courseTitle);
        msg.append(" in year ");
        msg.append(yearOfStudy);
        return msg.toString();
    }
}
