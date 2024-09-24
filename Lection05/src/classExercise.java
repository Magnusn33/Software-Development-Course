import java.util.ArrayList;
import java.util.List;

/**
 * A simple framework for working with lists.
 * @param <E> the type of elements in this list
 */
public class classExercise<E> {

    // List to hold elements of generic type E
    private List<E> list;

    /**
     * Constructor to initialize the list.
     */
    public classExercise() {
        this.list = new ArrayList<>();
    }

    /**
     * Adds an element to the list.
     * @param element the element to add
     */
    public void addElement(E element) {
        list.add(element);
    }

    /**
     * Removes an element from the list.
     * @param element the element to remove
     */
    public void removeElement(E element) {
        list.remove(element);
    }

    /**
     * Retrieves an element from the list by its index.
     * @param index the index of the element
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E getElement(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }

    /**
     * Displays all elements in the list.
     */
    public void displayElements() {
        for (E element : list) {
            System.out.println(element);
        }
    }

    /**
     * Main method to demonstrate the usage of the classExercise class.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Creating an instance of classExercise for String elements
        classExercise<String> stringList = new classExercise<>();

        // Adding elements to the list
        stringList.addElement("Hello");
        stringList.addElement("World");
        stringList.addElement("!");
        stringList.addElement("Goodbye");
        stringList.removeElement("World");

        System.out.println("\nElement at index 1: " + stringList.getElement(1));

        // Displaying all elements in the list
        //System.out.println("List elements:");
        //stringList.displayElements();

        // Retrieving and displaying an element at index 1
        //System.out.println("\nElement at index 1: " + stringList.getElement(1));

        // Removing an element from the list
        //stringList.removeElement("World");

        // Displaying all elements in the list after removal
        //System.out.println("\nList elements after removal:");
        //stringList.displayElements();
    }
}