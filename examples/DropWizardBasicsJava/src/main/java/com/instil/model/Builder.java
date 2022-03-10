package com.instil.model;

import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class Builder {
    public static Map<String, Course> buildPortfolio() {
        var data = Map.ofEntries(
                entry("AB12", new Course("AB12", "Programming in Scala", CourseDifficulty.BEGINNER, 4)),
                entry("CD34", new Course("CD34", "Machine Learning in Python", CourseDifficulty.INTERMEDIATE, 3)),
                entry("EF56", new Course("EF56", "Advanced Kotlin Coding", CourseDifficulty.ADVANCED, 2)),
                entry("GH78", new Course("GH78", "Intro to Domain Driven Design", CourseDifficulty.BEGINNER, 3)),
                entry("IJ90", new Course("IJ90", "Database Access with JPA", CourseDifficulty.INTERMEDIATE, 3)),
                entry("KL12", new Course("KL12", "Functional Design Patterns in F#", CourseDifficulty.ADVANCED, 2)),
                entry("MN34", new Course("MN34", "Building Web UIs with Angular", CourseDifficulty.BEGINNER, 4)),
                entry("OP56", new Course("OP56", "Version Control with Git", CourseDifficulty.INTERMEDIATE, 1)),
                entry("QR78", new Course("QR78", "SQL Server Masterclass", CourseDifficulty.ADVANCED, 2)),
                entry("ST90", new Course("ST90", "Go Programming for Beginners", CourseDifficulty.BEGINNER, 5)),
                entry("UV12", new Course("UV12", "Coding with Lock Free Algorithms", CourseDifficulty.INTERMEDIATE, 2)),
                entry("WX34", new Course("WX34", "Coaching Skills for SCRUM Masters", CourseDifficulty.ADVANCED, 3))
        );
        return new HashMap<>(data);
    }
}
