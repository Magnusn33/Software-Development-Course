import java.util.Random;

public class Grid {
    //vi sætter de forskellige konstanter
    private static final int SIZE = 9;
    private static final int OBJECT_COUNT = 10;
    private static final char EMPTY_CELL = '.';
    private static final char OBJECT_CELL = 'O';
    //vi laver et 2D array for at lave et gitter
    private char[][] grid;
    //vi laver en random for at placere objecter tilfældigt
    private Random random;

    public Grid() {
        //vi laver et nyt gitter og ligger konstanterne i
        grid = new char[SIZE][SIZE];
        random = new Random();
        //vi kalder de to metoder for at lave gitteret og placere objekterne
        initializeGrid();
        placeObjects();
    }

    private void initializeGrid() {
        // Sætter alle celler til . (tomme)
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = EMPTY_CELL;
            }
        }
        //vi placere et X i midten
        grid[SIZE / 2][SIZE / 2] = 'X';
    }
    //metode til at placere objekterne
    private void placeObjects() {
        int placedObjects = 0;
        while (placedObjects < OBJECT_COUNT) {
            // Vælger en tilfældig række
            int row = random.nextInt(SIZE);
            // Vælger en tilfældig kolonne
            int col = random.nextInt(SIZE);
            // Tjekker om cellen er tom
            if (grid[row][col] == EMPTY_CELL) {
                // Placerer et objekt i cellen
                grid[row][col] = OBJECT_CELL;
                // incrementer antallet af objekter
                placedObjects++;
            }
        }
    }

    public void printGrid() {
        // Udskriver hver celle
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j] + " ");
            }
            // Ny linje efter rækkerne
            System.out.println();
        }
    }
    //vi beregner afstandene fra midten af gitteret
    public int[] calculateDistances() {
        // de afstande gemmes i et array
        int[] distances = new int[4];
        // midterste række
        int midRow = SIZE / 2;
        // midterste kolonne
        int midCol = SIZE / 2;

        // Nord
        distances[0] = calculateDistance(midRow, midCol, -1, 0);
        // Øst
        distances[1] = calculateDistance(midRow, midCol, 0, 1);
        // Syd
        distances[2] = calculateDistance(midRow, midCol, 1, 0);
        // Vest
        distances[3] = calculateDistance(midRow, midCol, 0, -1);

        return distances;
    }
    //vi beregner afstanden fra midten af gitteret til objekterne
    private int calculateDistance(int startRow, int startCol, int rowStep, int colStep) {
        // initialiserer afstanden
        int distance = 0;
        // Start række
        int row = startRow;
        // Start kolonne
        int col = startCol;

        while (true) {
            // næste række
            row += rowStep;
            // næste kolonne
            col += colStep;
            distance++;
            // returner -1 hvis vi er udenfor gitteret
            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                return -1;
            }
            // Objekt fundet, returnerer afstanden
            if (grid[row][col] == OBJECT_CELL) {
                return distance;
            }
        }
    }
}
