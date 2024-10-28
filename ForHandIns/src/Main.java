import java.io.Console;
import java.util.List;

/**
 * The main class for this assigment, mainly handles user input
 * NOTE: the assignment is all solved in the Ceasar_Chipher class
 */
public class App {
    /**
     * Used to get user input
     */
    static Console scan = null;

    /**
     * Gets a userinput in the raw string format
     * @param message The desciptive message for the user, which is printed
     * @return the user typed string until they press enter
     */
    private static String getInput(String message){
        if(scan == null){//if the console object has not been loaded we, get it
            scan = System.console();
        }
        System.out.println(message);

        return scan.readLine();
    }

    /**
     * Gets an Integer from the user through the console
     * @param message an desciptiv text that is displayed to the user
     * @return the users Integer value
     */
    private static int getUserInteger(String message){
        if(scan == null){//if the console object has not been loaded we, get it
            scan = System.console();
        }

        System.out.println(message);//prints the message to the user
        while (true) {//We continue to wait for the user to input a Integer value
            String input = scan.readLine();

            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Dette er ikke et heltal");//if the user dont input a valid integer value, we print an correctiv text
            }
        }
    }

    /**
     * Gets a simplified Brutforce type from the user
     * @return the simplefied bruteforce type
     */
    private static Ceasar_Ciphier.BRUTE_TYPE getBruteUserChoice() {
        if(scan == null){//if the console object has not been loaded we, get it
            scan = System.console();
        }

        System.out.println("Vælg venligst brutforce metode [S]imple,[V]ocal eller [W]ordlist");//printes the options for the user
        System.out.println(//we explain that the type word list reqires a seperate file to load in words, that is needed to check validity of the brutforce result
                "Noter at med Wordlist, forventes at en fil med comma sepereret ord ligger i samme mappe som den eksekverbare fil, og kaldes wordlist_eng.csv i utf-8 format");
        Ceasar_Ciphier.BRUTE_TYPE type = Ceasar_Ciphier.BRUTE_TYPE.UNKNOWN;
        while (type == Ceasar_Ciphier.BRUTE_TYPE.UNKNOWN) {
            String input = scan.readLine().toUpperCase();//We turn tekst to upper case, for a sipmler handling of the user input 
            switch (input) {//We check the input for known types
                case "S":
                case "SIMPLE":
                    type = Ceasar_Ciphier.BRUTE_TYPE.SIMPLE;
                    break;
                case "V":
                case "VOCAL":
                    type = Ceasar_Ciphier.BRUTE_TYPE.VOCAL_WORDS;
                    break;
                case "W":
                case "WORD":
                    type = Ceasar_Ciphier.BRUTE_TYPE.WORDLIST_ENG;
                    break;
                default://The user did not input any known value, and we ask the user to input a valid type, and reminds the again what the options are.
                    System.out.println("Ukendt type, vælg venligst en valid type: [S]imple,[V]ocal eller [W]ordlist");
                    break;
            }
        }

        return type;
    }

    private static void printHelp() {//The application supports arguments, and this function prints out how to use the application
        System.out.println("Hjælp: \n-h Viser denne hjælpe tekst");
        System.out.println("-m\tmanuelt");
        System.out.println(
                "-k\tkrypter den efterfølgende data tekst strengen med chipoerval -v\n\teks. -k \"This is a Test\" -v 3");
        System.out.println(
                "-d\tdekrypter den efterfølgende data tekst strengen med chipoerval -v\n\teks. -d \"This is a Test\" -v 3");
        System.out.println(
                "-v\tchipher forskydnings værdi");
        System.out.println(
                "-b\tbruger brutforce metoden til at dekryptere den efterfølgende tekst kan bruges med argumenterne -s(default) -vo -w");
        System.out.println("-s\tbrutforce metode simple, der udskriver alle mulige udgaver af det krypterede data");
        System.out.println(
                "-vo\tbrutforce metode vocal, der udskriver alle filtreret på mulige ord som indeholder vocaler");
        System.out.println(
                "-w\tbrutforce metode \"word list\", der udskriver alle filtreret på mulige ord som indes i en liste fil kaldet wordlist_eng.csv");
    }

    /**
     * Used to ask the user what they want to basically do
     * @return a simplifede version of the user choise in form of a charakter K, D, B
     */
    private static char getUserChoice() {
        if(scan == null){//if the console object has not been loaded we, get it
            scan = System.console();
        }
        System.out.println("Ønsker du at [K]ryptere, [D]ecode eller [B]ruteforce?");
        char type = ' ';
        while (type == ' ') {
            String input = scan.readLine().toUpperCase();
            switch (input) {//Checks the userinput to finde the simplified version
                case "K":
                case "Kryptere":
                    type = 'K';
                    break;
                case "D":
                case "DECODE":
                    type = 'D';
                    break;
                case "B":
                case "BRUTEFORCE":
                    type = 'B';
                    break;
                default:
                    System.out.println(
                            "Ukendt valg, vælg venligst en valid metode: [K]ryptere, [D]ecode eller [B]ruteforce");
                    break;
            }
        }
        return type;
    }

    /**
     * Gets an arguments data
     * @param args The full argument list
     * @param pos The current position of the argument (not data)
     * @return a string version of the data
     */
    private static String getArgumentData(String[] args, int pos) {
        if (args.length <= pos + 1 || isArgumentModifier(args[pos + 1])) {//if the argument list length is shorter than expected or the next argument is a known argument, there is an user error, and we shutdown
            System.err.println("Manglende argumenter");
            System.exit(10);
        }
        return args[pos + 1].toUpperCase();
    }

    /**
     * checks if the argument is a known argument
     * @param arg the argument to be checked
     * @return the boolean state of the check
     */
    private static boolean isArgumentModifier(String arg) {
        return arg.equals("-h") || arg.equals("-m") || arg.equals("-k") || arg.equals("-d") || arg.equals("-s")
                || arg.equals("-vo") || arg.equals("-w") || arg.equals("-v");
    }

    /**
     * The main stating point the the application
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {//the application requires a argument to run
            Ceasar_Ciphier cipher = new Ceasar_Ciphier();
            if (args[0].equals("-m")) {//-m argument means that the user is ask about how to proced
                if(scan == null){//if the console object has not been loaded we, get it
                    scan = System.console();
                }

                char choice = getUserChoice();//we want to know what to do
                if (choice == 'K') {//the user answered encode
                    String input = getInput("Indtast tekst der skal krypteres:"); //we need a text to encode
                    cipher.setShift(getUserInteger("Indtast chipher værdi:"));//we need a integer value to encode the text 

                    System.out.println(cipher.encode(input));//encode and print the result
                } else if (choice == 'D') {//The user want to dekrypt a tekst
                    String input = getInput("Indtast tekst der skal krypteres:"); //we need a text to encode
                    cipher.setShift(getUserInteger("Indtast chipher værdi:"));//we need a integer value to encode the text 

                    System.out.println(cipher.decode(input));//decoode and print result 
                } else {//The user answered a brute force methode
                    Ceasar_Ciphier.BRUTE_TYPE type = getBruteUserChoice();//we need to give the user the choice of 

                    String data = getInput("Indtast de krypterede Data");//Gets the data to decode
                    List<BruteResult> decodedList = Ceasar_Ciphier.brutforce(data, type);//The brute force returns all possible values, accoridng to the type of bruteforce
                    System.out.println("************");//incase no result is printed, it is nice that the user dont wait for an answer
                    for (BruteResult decoded : decodedList) {//for possibillity we print the result
                        System.out.println(decoded);
                    }
                }
            } else {//it is assumed that the user has inputed all data as arguments.
                char methode = 'N';//the base methode, that is initialized as a neutral value
                String data = "";//the data variable to holde the data needed to handled
                Ceasar_Ciphier.BRUTE_TYPE bType = Ceasar_Ciphier.BRUTE_TYPE.SIMPLE;//The brutforce methode, and is default Simple
                for (int i = 0; i < args.length; i++) {//We go through all arguments in the args variable
                    switch (args[i]) {//we try and identify which argument that has been inputted on the current position in the array
                        case "-k"://if the -k value the user wants to encode the following data
                            methode = 'K';//we set the methode to ecoding
                            data = getArgumentData(args, i);//we get the next argument as data
                            i++;//since we got the next arguments as data, we also need to increment by on so the we dont make the check on the data
                            break;
                        case "-d"://if the -d value the user wants to decode the following data
                            methode = 'D';//we set the methode to decoding
                            data = getArgumentData(args, i);//we get the next argument as data
                            i++;//since we got the next arguments as data, we also need to increment by on so the we dont make the check on the data
                            break;
                        case "-v"://the user has inputted a chiper value/key
                            String tmp = getArgumentData(args, i);//we get the next argument as temporary string
                            i++;//since we got the next arguments as data, we also need to increment by on so the we dont make the check on the data
                            try {//we need to handle possible user error
                                cipher.setShift(Integer.parseInt(tmp));//we directly sets the value of chiper value
                                if (cipher.getShifter() < 0) {//if the chipher is negative, the program will alwase give wrong result
                                    System.err.println("argumentet for -v kan ikke være negativt");
                                    System.exit(10);
                                }
                            } catch (Exception ex) {//the input is in wrong format
                                System.err.println("argumentet for -v var ikke et heltalts værdi");
                                System.exit(10);
                            }
                            break;
                        case "-b"://the user has selected that the data needs to be brute forced
                            methode = 'B';//we set the type as bruteforce
                            data = getArgumentData(args, i);//we get the next argument as data
                            i++;//since we got the next arguments as data, we also need to increment by on so the we dont make the check on the data
                            break;
                        case "-s"://the argument -s meens that the brute force filte method is simple or none (showing all chipher methodes) 
                            bType = Ceasar_Ciphier.BRUTE_TYPE.SIMPLE;
                            break;
                        case "-vo"://the argument -vo meens that the brute force method is Vocal filtering on results that only contains words with vocal letters.
                            bType = Ceasar_Ciphier.BRUTE_TYPE.VOCAL_WORDS;
                            break;
                        case "-w"://the argument -w meens that the brute force method uses a wordlist to filter result to only valid cases.
                            bType = Ceasar_Ciphier.BRUTE_TYPE.WORDLIST_ENG;
                            break;
                        case "-h"://THe user wants us to print the help text
                            printHelp();
                            System.exit(0);
                            break;
                    }
                }

                if (methode == 'N') {//if the methode is value 'n' we know that the user has not inputtet an argument to tell what to do
                    System.err.println("Mangler metode argument");
                    System.exit(10);
                }
                if (methode == 'D') {//we decipher the argument data.. geussing that the user has inputted a chiper value
                    System.out.println(cipher.decode(data));
                } else if (methode == 'K') {//we encrypt the argument data.. geussing that the user has inputted a chiper value
                    System.out.println(cipher.encode(data));
                } else {//we brute force with the selected filter methode (Defualt SIMPLE)
                    List<BruteResult> result = Ceasar_Ciphier.brutforce(data, bType);

                    for (BruteResult bruteResult : result) {//Prints results
                        System.out.println(bruteResult);
                    }
                }
            }
        } else {//if no arguments are placed, we print help.
            printHelp();
        }
    }
}

*******************************************************************************************************************************************************************************************************************

/**
 * A class to store a brutefoce result
 */
public class BruteResult {
    /**
     * The chipher value the unlocked this version of the result
     */
    public int chipherValue = 0;
    /**
     * The resulting text of the decoding
     */
    public String text = "";

    /** Default constructor (so that we dont force use of other constructors) */
    BruteResult(){ }
    /**
     * The mainly used constructor
     * @param value the chipher decode key
     * @param text the text to be decoded
     */
    BruteResult(int value, String text){
        this.chipherValue = value;
        this.text = text;
    }

    /**
     * An easyer method to print out in the console, and other places to convert result, to a string
     * @return a textversion of the result
     */
    @Override
    public String toString() {
        return chipherValue + ":" + text;
    }
}

*******************************************************************************************************************************************************************************************************************

        import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The primary class for encoding and decoding the ceasar chipher
 */
public class Ceasar_Ciphier {
    /**
     * The value used to shift the text string characters
     */
    int shifter = 0;

    /**
     * The default constructor for the Ceasar cipher, and makes use of Random to put an value in the shifter value
     */
    public Ceasar_Ciphier() {
        shifter = new Random().nextInt(0, 25);
    }

    /**
     * a constructor to put the cipher value in before the object is build
     * @param shifter
     */
    public Ceasar_Ciphier(int shifter) {
        setShift(shifter);
    }

    /**
     * A method that sets the chiphier value.
     * @param shifter
     */
    public void setShift(int shifter) {
        while (shifter > 25) {// if the shifter is larger than 25 we need to reduse the number to the, the
            // result will be the same sins we use round robin to handle overflow letters
            shifter -= 25;
        }

        this.shifter = shifter;
    }

    /**
     * gets the chiper value
     * @return the current cipher value
     */
    public int getShifter() {
        return this.shifter;
    }

    /**
     * The function to decode a tekst input acording to the chipher value
     * @param input //the text data that needs to be deciphered
     * @return //the resulting text string, regardsles of rigth or wrong
     */
    public String decode(String input) {
        String output = "";
        input = input.toUpperCase();// The ceasar chipher only handles large letters

        for (int i = 0; i < input.length(); i++) {//runs trough all the charactes of the text string
            char current = input.charAt(i);//Picks out the current character
            if (current >= 'A' && current <= 'Z') {//if the text character does not contain a letter, we just add it to the output, without deciphering it
                if (current - shifter < 'A') {// if the shifting goes lower than the valuer of "A" we need to round
                    // robin to "Z"
                    int tmp = shifter - (current - 'A');//calulate the remainder of the shifting
                    output += (char) ('Z' + 1 - tmp);// we add 1 to "Z" to include "Z"
                } else {
                    output += (char) (current - shifter);//no need to round robin
                }
            } else {
                output += current;// if the charecter is not a letter we just parse it on
            }
        }

        return output;
    }

    /**
     * The function to encrypt a tekst input
     * @param input the tekst to encrypt
     * @return the result after encryption
     */
    public String encode(String input){
        input = input.toUpperCase();
        char current = 0;
        String output = "";

        for(int i = 0; i < input.length(); i++){
            current = input.charAt(i);
            if(current >= 'A' && current <= 'Z'){//if the text character does not contain a letter, we just add it to the output, without deciphering it
                if(current + shifter > 'Z'){//a round robin is nesesary when the shift is to large compared to 
                    int remainder = (current + shifter) - ('Z' + 1);//we finde the remainder over Z
                    output += (char)(remainder + 'A');//we add the remainder to the base of A
                }else{
                    output += (char)(current + shifter);//no need to round robin
                }
            }else{
                output += current;//if the charecter is not a letter we just parse it on
            }
        }

        return output;
    }

    /**
     * A enum to simplefy the selection of Brutforce sort type
     */
    public enum BRUTE_TYPE {
        SIMPLE,//Return all possible decryption versions
        WORDLIST_ENG, //only versions of decrypted senteces the corresponds with words in a word list
        VOCAL_WORDS, //only return versions of decrypted senteces with words that contain a vocal
        UNKNOWN //default value, when the type is unselected
    }

    /**
     * Returns if the inputed string (meant to be a single word) has a vocal imbedded
     * @param input the input string(Meant to be a single word)
     * @return a boolean true if just one vocal is in the tekst input
     */
    private static boolean hasWordsVocal(String input) {
        if (input.length() > 0) {
            String[] words = input.split(" ");// If java had a char splitter function, it wold solve the job at about 5
            // times faster. (Relative to the length of the input string)

            for (String word : words) {
                boolean test = false;
                for (int c = 0; c < word.length() && !test; c++) {
                    switch (word.charAt(c)) {// AEIOUY
                        case 'A':
                        case 'E':
                        case 'I':
                        case 'O':
                        case 'U':
                        case 'Y':
                            test = true;
                            break;
                        default:
                            break;
                    }
                }
                if(!test){
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * A overloaded function that add Default value to the wordlist variable
     * @param input //a decrypted tekst
     * @return a boolean true of all words in the string a contained within the list of words
     */
    public static boolean isStringOfWords(String input){
        return isStringOfWords(input, wordList());
    }

    /**
     * A function that checks if a string input only contains valid words from a list of words
     * @param input the string needed to be checked
     * @param words the list of valid words
     * @return true if all words in the input string is contained within the array of words
     */
    private static boolean isStringOfWords(String input, String[] words){
        input = input.toUpperCase();//as with the rest of the program we operate with large letters
        input = input.replace(",", "");//we remove all charakters that wont register as words, or offset a words visability
        input = input.replace(".", "");
        input = input.replace(";", "");
        input = input.replace("\'", "");
        String[] inputWords = input.split(" ");//we split alle words in the string, to make them easier to handle

        for (String iWord : inputWords) {//go through all words one by one in the string
            boolean wordExist = false;//we need a variable to change if a word has been found
            for(int i = 0; i < words.length && !wordExist; i++){//go through all the words as long as the word does not exists
                wordExist = iWord.equals(words[i]);//the expresion will only set wordExist to true if the 2 are equal, and the loop stops
            }
            if(!wordExist){
                return false;//if the word has not been found in the list, there is no reason to continue
            }
        }

        return true;//if all words in the string validates as true, we know that it is a valid expresive tekst (Not nessesaraly a meningfull text)
    }

    /**
     * a function to load a list of words from a file
     * @return the list of words or null if somthing goes realy wrong
     */
    private static String[] wordList() {
        try {
            String lines = new String(Files.readAllBytes(Paths.get("wordlist_eng.csv")), "UTF-8");//we read a complete file in the UTF-8 format into a string
            return lines.split(",");//split the string by comma "," and return the list
        } catch (Exception e) {//if an exeption is thrown, the file mos likely dont exist, and the user needs to be informed, and there is no reason to continue the program. (its console)
            System.err.println("No wordlist found...");
            System.exit(10);
        }

        return null;
    }

    /**
     * an overloading of the brutefoce method, to simplify the use
     * @param input the string to be brute forced
     * @return a list of possible answers
     */
    public static List<BruteResult> brutforce(String input) {
        return brutforce(input, BRUTE_TYPE.SIMPLE);
    }

    /**
     * A brute force method of decypting the ceasar cipher going throug each possible shifter value
     * @param input the string to be brute forced
     * @param type the type of filtering of the results: SIMPLE is all, Vocal uses vocals in all words, and WordList uses an list of words to validate the result
     * @return a list of possible answers
     */
    public static List<BruteResult> brutforce(String input, BRUTE_TYPE type) {
        List<BruteResult> results = new ArrayList<BruteResult>();//A list to contain the results

        Ceasar_Ciphier decode = new Ceasar_Ciphier();//only create one objekt to handle the decipher
        if (type == BRUTE_TYPE.SIMPLE) {
            for (int i = 1; i < 26; i++) {//go through each possible shifter value (0 gives no shift) (and 26 always produce the same result as 1)
                decode.setShift(i);//set the shifter value
                results.add(new BruteResult(i, decode.decode(input)));//add the result, and let the user decide
            }
        } else if (type == BRUTE_TYPE.VOCAL_WORDS) {
            String result = "";//a temporary store for a result
            for (int i = 1; i < 26; i++) {//go through each possible shifter value (0 gives no shift) (and 26 always produce the same result as 1)
                decode.setShift(i);//set the shifter value
                result = decode.decode(input);
                if (Ceasar_Ciphier.hasWordsVocal(result)) {//run the check if the words has a vocal in them, at least they are speakable, and we get closer to the real text
                    results.add(new BruteResult(i, result));//add the result
                }
            }
        } else {
            String[] wordList = wordList();
            String result = "";//a temporary store for a result
            for (int i = 1; i < 26; i++) {//go through each possible shifter value (0 gives no shift) (and 26 always produce the same result as 1)
                decode.setShift(i);//set the shifter value
                result = decode.decode(input);
                if (Ceasar_Ciphier.isStringOfWords(result, wordList)) {//the list of words ensure that the deciphered is valid... if the list is complet, and it hits the correct language
                    results.add(new BruteResult(i, result));//add the result
                }
            }
        }
        return results;//send back the list of possibilities
    }
}
