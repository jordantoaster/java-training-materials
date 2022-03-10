package com.instil.model

object Builder {
    fun buildPortfolio() = mutableMapOf(
        "AB12" to Course("AB12", "Programming in Scala", CourseDifficulty.BEGINNER, 4),
        "CD34" to Course("CD34", "Machine Learning in Python", CourseDifficulty.INTERMEDIATE, 3),
        "EF56" to Course("EF56", "Advanced Kotlin Coding", CourseDifficulty.ADVANCED, 2),
        "GH78" to Course("GH78", "Intro to Domain Driven Design", CourseDifficulty.BEGINNER, 3),
        "IJ90" to Course("IJ90", "Database Access with JPA", CourseDifficulty.INTERMEDIATE, 3),
        "KL12" to Course("KL12", "Functional Design Patterns in F#", CourseDifficulty.ADVANCED, 2),
        "MN34" to Course("MN34", "Building Web UIs with Angular", CourseDifficulty.BEGINNER, 4),
        "OP56" to Course("OP56", "Version Control with Git", CourseDifficulty.INTERMEDIATE, 1),
        "QR78" to Course("QR78", "SQL Server Masterclass", CourseDifficulty.ADVANCED, 2),
        "ST90" to Course("ST90", "Go Programming for Beginners", CourseDifficulty.BEGINNER, 5),
        "UV12" to Course("UV12", "Coding with Lock Free Algorithms", CourseDifficulty.INTERMEDIATE, 2),
        "WX34" to Course("WX34", "Coaching Skills for SCRUM Masters", CourseDifficulty.ADVANCED, 3)
    )
}
