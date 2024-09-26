import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        int totalEcts = 0;
        int CourseCount = 0;

        List<Course> courses = new ArrayList<>();
        courses.add(new BasicCourse(5, "EssentialComputing"));
        courses.add(new ElectiveCourse(10, "LinearAlgebra"));

        // Print courses
        for (Course course : courses) {
            System.out.println(course.getType() + " Course, ECTS: " + course.getEcts() + ",Name: " + course.getName());
        }

        for (Course course : courses) {
            if (course instanceof SubjectCourse) {
                CourseCount++;
            }
        }





    }
}