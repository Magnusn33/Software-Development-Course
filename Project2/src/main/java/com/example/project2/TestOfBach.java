package com.example.project2;

public class TestOfBach {
    public static void main(String[] args) {
        // Initialize a BachelorProgram
        BachelorProgram program = new BachelorProgram();

        // Add courses to the program
        program.addCourse(new BasicCourse(5, "EssentialComputing"));
        program.addCourse(new ElectiveCourse(10, "LinearAlgebra", "Basis"));
        program.addCourse(new BachelorProject("TechnoStress"));
        program.addCourse(new BasisProject("RPA1"));
        program.addCourse(new BasisProject("RPA2"));
        program.addCourse(new BasisProject("RPA3"));
        program.addCourse(new SubjectProject("Gamification", "GameDesign"));
        program.addCourse(new SubjectCourse(5, "Digital Stress", "GameDesign"));
        program.addCourse(new SubjectCourse(5, "Stress", "Design"));
        program.addCourse(new BasicCourse(10, "EssentialComputing2"));
        program.addCourse(new BasicCourse(10, "EssentialComputing3"));
        program.addCourse(new BasicCourse(10, "EssentialComputing4"));
        program.addCourse(new BasicCourse(10, "EssentialComputing5"));
        program.addCourse(new BasicCourse(10, "EssentialComputing6"));
        program.addCourse(new BasicCourse(10, "EssentialComputing7"));
        program.addCourse(new BasicCourse(10, "EssentialComputing8"));
        program.addCourse(new BasicCourse(10, "EssentialComputing9"));

        // Print all courses in the program
        BachelorProgram.printCourses(program.courses);

        // Print the total number of ECTS in the program
        System.out.println("Total ECTS: " + BachelorProgram.countTotalEcts(program.courses));

        // Check if the program is valid and print the result
        System.out.println("Valid: " + BachelorProgram.valid(program.courses, BachelorProgram.CountInstance(program.courses)));
    }
}