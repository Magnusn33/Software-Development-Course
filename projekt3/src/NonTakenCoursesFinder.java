import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NonTakenCoursesFinder {
    public static List<String[]> findAllNonTakenCourses(SubjectGraph subjectGraph) {
        List<String[]> nonTakenCoursesList = new ArrayList<>();
        Map<Integer, String> indexSubjectMap = new HashMap<>();

        // Create a map from index to subject name based on the subjectIndexMap from subjectGraph
        for (Map.Entry<String, Integer> entry : subjectGraph.getSubjectIndexMap().entrySet()) {
            indexSubjectMap.put(entry.getValue(), entry.getKey());
        }

        int[][] matrix = subjectGraph.getMatrix();

        // Iterate through the adjacency matrix to find non-taken courses
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Check if no students have taken both subjects
                if (matrix[i][j] == 0 && i != j) {
                    nonTakenCoursesList.add(new String[]{indexSubjectMap.get(i), indexSubjectMap.get(j)});
                }
            }
        }
        return nonTakenCoursesList;
    }

    public static void printNonTakenCourses(List<String[]> nonTakenCourses) {
        System.out.println("Non-Taken Courses:");
        // Print each pair of non-taken courses
        for (String[] coursePair : nonTakenCourses) {
            System.out.println(coursePair[0] + " " + coursePair[1]);
        }
    }
}