package com.instil.model

class Course(
    var id: String,
    var title: String,
    var difficulty: CourseDifficulty,
    var duration: Int
) {
    //Required for unmarshalling
    constructor() : this("", "", CourseDifficulty.BEGINNER, 0)
}
