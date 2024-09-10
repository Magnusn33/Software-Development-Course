public class Main {
    public static void main(String[] args) {
        /*
        int[] number;
        int[] reverseNumber;

        number = FirstExercise.buildArray();
        reverseNumber = FirstExercise.reverseArray(number);
        FirstExercise.printArray(reverseNumber);
        */

        Counter.main(args);
    }
}

class FirstExercise {
    public static int[] buildArray() {
        int[] number = new int[10];

        for (int i = 1; i <= number.length; i++) {
            number[i-1] = i;
        }
        return number;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - i - 1];
        }
        return reversedArray;
    }
}

class Counter {
    public static void main(String[] args) {
        Counter cnt = new Counter();
        int field = 0;

        while (cnt.more(field)) {
            System.out.println(field);
            field = cnt.next(field);
        }
    }

    public int next(int number) {
        number = number + 1;
        return number;
    }

    public boolean more(int number) {
        return number < 10;
    }


}