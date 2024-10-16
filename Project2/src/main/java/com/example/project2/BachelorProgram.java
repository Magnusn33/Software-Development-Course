package com.example.project2;

import java.util.ArrayList;
import java.util.List;

public class BachelorProgram {
    // List for courses in the bachelor program
    List<Course> courses = new ArrayList<>();

    // Method for adding an instance to the list of courses
    void addCourse(Course course) {courses.add(course);}

    // Method to count the amount of instances of a class
    public static int[] CountInstance(List<Course> courses) {
        // Array to store the number of instances in
        int[] array = new int[6];

        // Count number of x
        for (Course course : courses) {
            if (course instanceof ElectiveCourse) {
                array[0]++;
            } else if (course instanceof SubjectCourse) {
                array[1]++;
            } else if (course instanceof BasicCourse) {
                array[2]++;
            } else if (course instanceof BachelorProject) {
                array[3]++;
            } else if (course instanceof BasisProject) {
                array[4]++;
            } else if (course instanceof SubjectProject) {
                array[5]++;
            }
        }
        return array;
    }

    // Method to count the amount of ECTS
    public static int countTotalEcts(List<Course> courses) {
        int totalEcts = 0;

        // Iterate through the list and add the ects together
        for (Course course : courses) {
            totalEcts += course.getEcts();
        }
        return totalEcts;
    }

    // Method to print all the instances of the classes
    public static void printCourses(List<Course> courses) {
        // Print courses
        for (Course course : courses) {
            System.out.println(course.getType() + " Course, ECTS: " + course.getEcts() + ", Name: " + course.getName() + " Module: " + course.getNameOfModule());
        }
    }

    // Method to check if there are two instances with the same name
    public static boolean checkRepeatingNames(List<Course> courses) {
        // Initializes lists to keep track of course names and their counts
        List<String> courseNames = new ArrayList<>();
        List<Integer> courseCounts = new ArrayList<>();

        // Iterate through the list of courses
        for (Course course : courses) {
            // Get the name of the current course
            String courseName = course.getName();
            // Find the index of the course name in courseNames list
            int index = courseNames.indexOf(courseName);
            if (index == -1) {
                // If the course name is not already in the list, add it and set its count to 1
                courseNames.add(courseName);
                courseCounts.add(1);
            } else {
                // If the course name is already in the list, increment its count
                courseCounts.set(index, courseCounts.get(index) + 1);
            }
        }

        // Check for any course names that are 1<
        for (int i = 0; i < courseNames.size(); i++) {
            if (courseCounts.get(i) > 1)
                return false;
        }
        return true;
    }

    // Method to check if the Bachelor program is valid
    public static boolean valid(List<Course> courses, int[] counts) {

        //BachelorProject
        if (counts[3] != 1) {
            System.out.println("Program missing a Bachelor Project");
            return false;
        }
        //BasisProject
        if (counts[4] != 3) {
            System.out.println("Program has " + counts[4] + " Basis project. It needs to be: 3");
            return false;
        }
        //Does it have the required amount of ects?
        if (countTotalEcts(courses) != 180) {
            System.out.println("Program has: " + countTotalEcts(courses) + " Ects. It needs to be: 180");
            return false;
        }
        //Checks if there are 2 courses with the same name
        if (!checkRepeatingNames(courses)) {
            System.out.println("Program has two courses with the same name");
            return false;
        }
        
        return true;
    }

}
