import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class SubjectGraph {
    private final Map<String, Integer> subjectIndexMap;
    private final int[][] matrix;
    private final Set<String> subjects;
    private final String fileName;

    // Constructor
    public SubjectGraph(String fileName) {
        this.fileName = fileName;
        this.subjectIndexMap = new HashMap<>();
        this.subjects = gatherSubjects(fileName);

        int index = 0;
        for (String subject : subjects) {
            subjectIndexMap.put(subject, index++); // Map each subject to an index
        }

        int n = subjects.size();
        this.matrix = new int[n][n];
        fillMatrix(); // Fill the adjacency matrix with data from the file
    }

    // Gather all unique subjects from the file
    private Set<String> gatherSubjects(String fileName) {
        Set<String> subjects = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" , "); // Split line into parts
                subjects.add(parts[0].trim()); // Add subjects to the set
                subjects.add(parts[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return subjects;
    }

    // Fill the adjacency matrix with number of students between subjects
    public void fillMatrix() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" , "); // Split line into parts
                String subject1 = parts[0].trim();
                String subject2 = parts[1].trim();
                int students = Integer.parseInt(parts[2].trim());

                int index1 = subjectIndexMap.get(subject1);
                int index2 = subjectIndexMap.get(subject2);

                matrix[index1][index2] = students;
                matrix[index2][index1] = students;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Print the adjacency matrix to the console
    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int[] row : matrix) {
            for (int cell : row) {
                // Print each cell with a width of 4
                System.out.printf("%4d", cell);
            }
            System.out.println();
        }
    }

    // Check if the graph is connected using DFS
    public boolean isConnected() {
        int n = matrix.length;
        boolean[] visited = new boolean[n];
        recursiveFindMatch(0, visited);

        for (boolean vertexVisited : visited) {
            if (!vertexVisited) {
                return false;
            }
        }
        return true;
    }

    // Recursive DFS to mark visited vertices
    private void recursiveFindMatch(int vertex, boolean[] visited) {
        visited[vertex] = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[vertex][i] > 0 && !visited[i]) {
                recursiveFindMatch(i, visited); // Continue DFS for adjacent vertices
            }
        }
    }

    // Print if the graph is connected
    public void printConnected() {
        boolean isConnected = isConnected();
        System.out.println("The graph is " + (isConnected ? "connected" : "not connected"));
    }

    // Get the mapping of subjects to their indices
    public Map<String, Integer> getSubjectIndexMap() {
        return subjectIndexMap;
    }

    // Get the adjacency matrix
    public int[][] getMatrix() {
        return matrix;
    }
}