import java.util.Scanner;
public class Hangman {
    public static void main(String[] args){
        //skaber ordet, som brugeren skal gætte, hvorefter det bliver konverteret til lowercase
        //for at skabe en rød tråd mellem brugerens input og selve ordet.
        //formålet er at brugeren skal kunne skrive både store og små chars, hvor programmet stadig godtager det
        String ord = "Pat".toLowerCase();
        //definerer 2 int variabler, vi kan arbejde med for at sikre at brugeren ikke har over 8 forsøg
        int maxAttempts = 8;
        int attempts = 0;
        //erstatter ordet, brugeren skal gætte med punktummer
        String skjultOrd = ".".repeat(ord.length());
        //printer hvad brugeren gætte i punktummer, så de kan se ordets længde
        System.out.println("Jeg har lavet et hemmeligt ord du skal gætte: " + skjultOrd);
        //definerer en variabel for brugerens input
        Scanner guess = new Scanner(System.in);


        //while loop, der kører så længe at brugerens forsøg er under 8
        //og så længe at variablen skjultOrd ikke er det samme som ord variablen
        while (attempts < maxAttempts && !skjultOrd.equals(ord)) {
            //printer "gæt bogstav"
            System.out.print("Gæt bogstav: ");
            //her modtager vi brugerens input
            // variablen er defineret som en character, derfor modtager vi kun et bogstav
            //det blivere konverteret til lowercase for at sikre at programmet modtager både store og små chars
            char c = guess.next().toLowerCase().charAt(0);
            //if-statement, der tjekker om brugerens input er en del af "ord" variablen
            //hvis det er returneres en værdi, og linje 32 bliver printet
            //hvis det ikke er køres "else"
            if (ord.indexOf(c) != -1) {
                System.out.println("Godt gættet! Bogstavet '" + c + "' er i ordet.");
                //her opdaterer vi det skjulte ord, ved at kalde på metoden "opdaterSkjultOrd"
                skjultOrd = opdaterSkjultOrd(ord, skjultOrd, c);
                //her kører else, som beskrevet i tidligere kommentar
            } else {
                System.out.println("Desværre, bogstavet '" + c + "' er ikke i ordet.");
            }
            //denne linje printer efter hvert forsøg fra brugeren, for at vise det eventuelt opdaterede ord
            System.out.println("Ordet er nu: " + skjultOrd);
            //tilføjer +1 til attempts, essentielt for at afslutte while-loopet, i tilfælde af at alle gæt er opbrugt
            attempts ++;
        }
        //if-stateement, der tjekker om variablen skjultOrd er = variablen ord
        //hvis den er printes linje 47
        if (skjultOrd.equals(ord)) {
            System.out.println("Tillykke! Du har gættet ordet korrekt: " + ord);
            //hvis ordet ikke er gættet og while-loopet er afsluttet(altså forsøgene er opbrugt) printes linje 50
        } else {
            System.out.println("Du har brugt alle dine forsøg uden at gætte ordet og er død. Ordet var: " + ord);
        }
    }
    //metode, til at opdatere det skjulte ord, der vises for brugeren
    //metoden tager 3 parametre: 2 strings (variablerne ord og skjultOrd samt 1 char, der er brugerens input)
    private static String opdaterSkjultOrd(String ord, String skjultOrd, char c) {
        //her bruger jeg en stringbuilder, for hele tiden at kunne ændre på ellers immutable string-variabler
        //vi laver en ny variabel med navnet opdateretOrd, og sætter den = variablen skjultOrd
        //derfor er opdateretOrd variablen = eks. (.....) men i en version som kan ændres
        StringBuilder opdateretOrd = new StringBuilder(skjultOrd);
        //for loop, der placerer brugerens input(c) på den værdi, den passer til i det ord, der skal gættes
        //såfremt at der er et match i ordet
        for (int i = 0; i < ord.length(); i++) {
            if (ord.charAt(i) == c) {
                opdateretOrd.setCharAt(i, c);
            }
        }
        //konverterer stringbuilder variablen opdateretOrd til en normal string samtidig med jeg afslutter metoden
        return opdateretOrd.toString();
    }
}