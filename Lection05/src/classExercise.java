import java.util.ArrayList;
import java.util.List;

public class classExercise<E> {

    private List<E> list;

    public classExercise() {
        this.list = new ArrayList<>();
    }
    public void addElement(E element) {
        list.add(element);
    }
    public void removeElement(E element) {
        list.remove(element);
    }
    public E getElement(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
    }
    public void displayElements() {
        for (E element : list) {
            System.out.println(element);
        }
    }
    public void reverseList() {
        List<E> reversedList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversedList.add(list.get(i));
        }
        list = reversedList;
    }

    public static void main(String[] args) {
        // Creating an instance of classExercise for String elements
        classExercise<String> stringList = new classExercise<>();


        // Adding some elements to the list
        stringList.addElement("one");
        stringList.addElement("two");
        stringList.addElement("three");

        // Displaying elements before reversing the list
        System.out.println("Elements before reversing:");
        stringList.displayElements();

        // Reversing the list
        stringList.reverseList();

        // Displaying elements after reversing the list
        System.out.println("Elements after reversing:");
        stringList.displayElements();

        System.out.println();
        System.out.println(stringList.getElement(1));


    }
}