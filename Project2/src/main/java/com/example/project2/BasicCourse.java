package com.example.project2;

public class BasicCourse extends Course {
    public BasicCourse(int ects, String name) {
        super(ects, name, "Basic");
    }

    @Override
    String getType() {
        return "BasicCourse";
    }

}
