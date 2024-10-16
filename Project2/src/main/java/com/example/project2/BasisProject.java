package com.example.project2;

public class BasisProject extends Course {
    public BasisProject(String name) {
        super(15, name, "Basic");
    }

    @Override
    String getType() {
        return "BasisProject";
    }
}
