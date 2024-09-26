import java.util.ArrayList;
import java.util.List;


public class BachelorProgram {
    List<Course> courses = new ArrayList<>();
    void addCourse(Course course) {courses.add(course);}
    public static void main(String[] args)
    {
        //List<Course> courses = new ArrayList<>();
        BachelorProgram program = new BachelorProgram();
        program.addCourse(new BasicCourse(5, "EssentialComputing"));
        program.addCourse(new ElectiveCourse(10, "LinearAlgebra"));
        program.addCourse(new SubjectCourse(5, "DiscreteMathematics"));
        program.addCourse(new BachelorProject("TechnoStress"));
        program.addCourse(new BasisProject("RPA"));
        program.addCourse(new SubjectProject("Gamification"));

        //Print Courses
        printCourses(program.courses);

        // Print number of instances
        printInstances(CountInstance(courses));

        // Print number of total ECTS
        System.out.println("Total ECTS: " + countTotalEcts(courses));
    }

    public static void printInstances(int[] counts) {
        System.out.println("ElectiveCourse: " + counts[0]);
        System.out.println("SubjectCourse: " + counts[1]);
        System.out.println("BasicCourse: " + counts[2]);
        System.out.println("BachelorProject: " + counts[3]);
        System.out.println("BasisProject: " + counts[4]);
        System.out.println("SubjectProject: " + counts[5]);
    }

    public static int[] CountInstance(List<Course> courses) {
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

    public static int countTotalEcts(List<Course> courses) {
        int totalEcts = 0;

        for (Course course : courses) {
            totalEcts += course.getEcts();
        }
        return totalEcts;
    }

    public static void printCourses(List<Course> courses) {
        // Print courses
        for (Course course : courses) {
            System.out.println(course.getType() + " Course, ECTS: " + course.getEcts() + ", Name: " + course.getName());
        }
    }

}
