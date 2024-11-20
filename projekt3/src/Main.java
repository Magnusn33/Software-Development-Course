import java.util.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "src/combi.txt";
        SubjectGraph subjectGraph = new SubjectGraph(fileName);

        // Print the adjacency matrix
        subjectGraph.printMatrix();

        // Check if the graph is connected and print the result
        subjectGraph.printConnected();

        // Find and print all non-taken courses combinations
        List<String[]> nonTakenCourses = NonTakenCoursesFinder.findAllNonTakenCourses(subjectGraph);
        NonTakenCoursesFinder.printNonTakenCourses(nonTakenCourses);
    }
}
