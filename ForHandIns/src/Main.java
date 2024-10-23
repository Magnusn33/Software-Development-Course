public class Main {
    public static void main(String[] args) {
        //Bogstaverne i den krypterede besked der skal knækkes
        String Koden = "XIXK QROFKD ZOXZHBA QEB BKFDJX.";

        // Vi ved at der er 25 mulige forskydninger så derfor sætter vi en int til 1 og laver et for loop hvor vi increamenter det
        for (int shift = 1; shift < 26; shift++) {
            // for hvergang vi har forskudt det printer vi antallet af forskydninger der er sket + descrypt metoden med teksten
            System.out.println("Shift " + shift + ": " + decrypt(Koden, shift));
        }
    }

    // For at forskyde en tekst skal vi først fortælle metoden hvorfor noget tekst og hvordan det skal forskydes
    public static String decrypt(String text, int shift) {
        // vi laver en ny StringBuilder som vi kan tilføje koden i
        StringBuilder result = new StringBuilder();

        // Vi laver en for loop for hvert bogstav = med antallet af bogstaver i koden
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // sørger for at bibeheolde mellemrum ved at forsætte hvis det er et mellemrum
            if (c == ' ') {
                result.append(c);
                continue;
            }

            // Forskyd tegnet tilbage med den givne forskydningsmængde
            char shifted = (char) (c - shift);

            // Hvis det bliver forskudt til noget før A  trækker vi 26 fra for at starte forfra
            if (shifted < 'A') {
                shifted += 26;
            }

            // tilføj bogstavet til vores StringBuilder
            result.append(shifted);
        }

        // aflevere den færdige forskudte tekst tilbage til main metoden
        return result.toString();
    }
}