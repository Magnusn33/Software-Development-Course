public class Main {
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
        program.addCourse(new SubjectCourse(85, "Digital Stress", "Design"));


        // Print all courses in the program
        BachelorProgram.printCourses(program.courses);

        // Print the number of instances of each course type
        BachelorProgram.printInstances(BachelorProgram.CountInstance(program.courses));

        // Print the total number of ECTS in the program
        System.out.println("Total ECTS: " + BachelorProgram.countTotalEcts(program.courses));

        // Check if the program is valid and print the result
        System.out.println("Valid: " + BachelorProgram.valid(program.courses, BachelorProgram.CountInstance(program.courses)));
    }
}