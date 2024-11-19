import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

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
    }

    public static int[][] fillMatrix(int[][] matrix, String fileName, Map<String, Integer> subjectIndexMap) {
        // Step 2: Read the file again and fill the adjacency matrix
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

        return matrix;
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





}