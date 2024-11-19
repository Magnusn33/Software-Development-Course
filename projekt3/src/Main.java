import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String fileName = "src/combi.txt";
        Map<String, Integer> subjectIndexMap = new HashMap<>();
        Set<String> subjects = new HashSet<>();

        // Read the file and gather all subjects
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" , ");
                subjects.add(parts[0].trim());
                subjects.add(parts[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create an index for each subject
        int index = 0;
        for (String subject : subjects) {
            subjectIndexMap.put(subject, index++);
        }

        // Initialize the adjacency matrix
        int n = subjects.size();
        int[][] matrix = new int[n][n];

        fillMatrix(matrix, fileName, subjectIndexMap);
        printMatrix(matrix, n);
        printConnected(matrix);
        List <String[]> nonTakenCourses = findAllNonTakenCourses(matrix, subjectIndexMap);
        printNonTakenCourses(nonTakenCourses);
    }

    public static List<String[]> findAllNonTakenCourses(int[][] matrix, Map<String, Integer> subjectIndexMap) {
        List<String[]> nonTakenCoursesList = new ArrayList<>();
        Map<Integer, String> indexSubjectMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : subjectIndexMap.entrySet()) {
            indexSubjectMap.put(entry.getValue(), entry.getKey());
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0 && i != j) { // check if the indices are not the same
                    nonTakenCoursesList.add(new String[]{indexSubjectMap.get(i), indexSubjectMap.get(j)});
                }
            }
        }

        return nonTakenCoursesList;
    }

    public static void printNonTakenCourses(List<String[]> nonTakenCourses) {
        System.out.println("Non-Taken Courses:");
        for (String[] coursePair : nonTakenCourses) {
            System.out.println(coursePair[0] + " " + coursePair[1]);
        }
    }

    public static void fillMatrix(int[][] matrix, String fileName, Map<String, Integer> subjectIndexMap) {
        // Read the file again and fill the adjacency matrix
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" , ");
                String subject1 = parts[0].trim();
                String subject2 = parts[1].trim();
                int students = Integer.parseInt(parts[2].trim());

                int index1 = subjectIndexMap.get(subject1);
                int index2 = subjectIndexMap.get(subject2);

                // Fill both directions
                matrix[index1][index2] = students;
                matrix[index2][index1] = students;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printMatrix(int[][] matrix, int n) {
        // Print the adjacency matrix in a structured way
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isConnected(int[][] matrix) {
        int n = matrix.length;
        boolean[] visited = new boolean[n];

        // Start the finMatch from vertex 0
        recursiveFindMatch(matrix, 0, visited);

        // Check if all vertices are visited
        for (boolean vertexVisited : visited) {
            if (!vertexVisited) {
                return false;
            }
        }
        return true;
    }

    private static void recursiveFindMatch(int[][] matrix, int vertex, boolean[] visited) {
        visited[vertex] = true;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[vertex][i] > 0 && !visited[i]) {
                recursiveFindMatch(matrix, i, visited);
            }
        }
    }

    private static void printConnected(int[][] matrix) {
        boolean isConnected = isConnected(matrix);

        System.out.println("The graph is " + (isConnected ? "connected" : "not connected"));
    }


}