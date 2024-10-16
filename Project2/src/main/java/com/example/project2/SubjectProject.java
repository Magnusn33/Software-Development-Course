package com.example.project2;

public class SubjectProject extends Course {
    public SubjectProject(String name, String NameOfModule) {
        super(15, name, NameOfModule);
    }

    @Override
    String getType() {
        return "SubjectProject";
    }

}
