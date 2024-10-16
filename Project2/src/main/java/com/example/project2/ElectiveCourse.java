package com.example.project2;

public class ElectiveCourse extends Course {
    public ElectiveCourse(int ects, String name, String NameOfModule) {
        super(ects, name, NameOfModule);
    }

    @Override
    String getType() {
        return "ElectiveCourse";
    }
}
