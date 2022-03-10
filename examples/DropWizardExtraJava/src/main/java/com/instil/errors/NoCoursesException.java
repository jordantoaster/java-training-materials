package com.instil.errors;

public class NoCoursesException extends RuntimeException {
    public NoCoursesException(String message) {
        super(message);
    }
}
