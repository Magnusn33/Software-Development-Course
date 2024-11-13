import java.util.Random;
public class Main {
    public static void main(String[] args) {
        // Definerer størrelsen på gitteret. Vi opretter et 9x9 gitter.
        int gridSize = 9;

        // Opretter et 2D-array, der repræsenterer gitteret. Hver celle i gitteret har en værdi af 0 (tom) eller 1 (objekt).
        int[][] grid = new int[gridSize][gridSize];

        // Antallet af objekter, vi vil placere tilfældigt i gitteret
        int objectCount = 10;

        // Opretter en instans af Random-klassen, der bruges til at generere tilfældige positioner i gitteret
        Random random = new Random();

        // Løkke til at placere 10 objekter tilfældigt i gitteret
        for (int i = 0; i < objectCount; i++) {
            int x, y;
            do {
                // Genererer tilfældige x- og y-koordinater inden for gitterets størrelse (0 til 8)
                x = random.nextInt(gridSize);
                y = random.nextInt(gridSize);

                // Sørger for, at vi ikke placerer et objekt, hvor der allerede er et andet objekt
                // Hvis der allerede er et objekt i cellen, genereres en ny position
            } while (grid[x][y] == 1);

            // Marker cellen som optaget af et objekt ved at sætte værdien til 1
            grid[x][y] = 1;
        }

        // Definerer midterpositionen i gitteret. I et 9x9 gitter er midten (4,4) i 0-baseret index
        int centerX = gridSize / 2;
        int centerY = gridSize / 2;

        // Variabler til at gemme afstanden til nærmeste objekt i hver retning. Initialværdi -1 indikerer, at der ikke er fundet noget objekt.
        int northDistance = -1, eastDistance = -1, southDistance = -1, westDistance = -1;

        // Beregner afstanden til nærmeste objekt i nordlig retning (ovenfor centeret)
        for (int i = centerX - 1; i >= 0; i--) {
            // Tjekker cellerne fra midten og opefter mod kanten af gitteret
            if (grid[i][centerY] == 1) {  // Hvis en celle indeholder et objekt (værdi 1)
                northDistance = centerX - i;  // Beregn afstanden fra centeret til denne celle
                break;  // Stop løkken, når vi har fundet det nærmeste objekt i nord
            }
        }

        // Beregner afstanden til nærmeste objekt i østlig retning (til højre for centeret)
        for (int j = centerY + 1; j < gridSize; j++) {
            // Tjekker cellerne fra midten og mod højre til kanten af gitteret
            if (grid[centerX][j] == 1) {  // Hvis en celle indeholder et objekt (værdi 1)
                eastDistance = j - centerY;  // Beregn afstanden fra centeret til denne celle
                break;  // Stop løkken, når vi har fundet det nærmeste objekt i øst
            }
        }

        // Beregner afstanden til nærmeste objekt i sydlig retning (nedenfor centeret)
        for (int i = centerX + 1; i < gridSize; i++) {
            // Tjekker cellerne fra midten og nedefter mod kanten af gitteret
            if (grid[i][centerY] == 1) {  // Hvis en celle indeholder et objekt (værdi 1)
                southDistance = i - centerX;  // Beregn afstanden fra centeret til denne celle
                break;  // Stop løkken, når vi har fundet det nærmeste objekt i syd
            }
        }

        // Beregner afstanden til nærmeste objekt i vestlig retning (til venstre for centeret)
        for (int j = centerY - 1; j >= 0; j--) {
            // Tjekker cellerne fra midten og mod venstre til kanten af gitteret
            if (grid[centerX][j] == 1) {  // Hvis en celle indeholder et objekt (værdi 1)
                westDistance = centerY - j;  // Beregn afstanden fra centeret til denne celle
                break;  // Stop løkken, når vi har fundet det nærmeste objekt i vest
            }
        }

        // Udskriver en skriftlig repræsentation af gitteret, hvor centeret er markeret med 'C', objekter med 'X', og tomme celler med '.'
        System.out.println("Gitter:");
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                // Hvis det er centeret, udskrives 'C'
                if (i == centerX && j == centerY) {
                    System.out.print("C ");
                } else {
                    // Udskriv 'X' for objekter og '.' for tomme celler
                    System.out.print((grid[i][j] == 1 ? "X " : ". "));
                }
            }
            System.out.println();  // Ny linje efter hver række i gitteret
        }

        // Udskriver de beregnede afstande til nærmeste objekt i hver retning
        System.out.println("\nAfstande fra centeret til nærmeste objekt:");
        // Hvis ingen objekt blev fundet i en retning, vises "Intet objekt"
        System.out.println("Nord: " + (northDistance == -1 ? "Intet objekt" : northDistance));
        System.out.println("Øst: " + (eastDistance == -1 ? "Intet objekt" : eastDistance));
        System.out.println("Syd: " + (southDistance == -1 ? "Intet objekt" : southDistance));
        System.out.println("Vest: " + (westDistance == -1 ? "Intet objekt" : westDistance));
    }
}