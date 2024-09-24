public class my_linkedList {
    private Node head;
    private int size;

    // Node class for linked list
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }


    // Constructor to initialize the linked list
    public my_linkedList() {
        head = null;
        size = 0;
    }

    // Method to add an element to the linked list
    public void add(int element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Method to get an element at a given index
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Method to remove an element at a given index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    // Method to get the current size of the linked list
    public int size() {
        return size;
    }

    // Method to print the elements of the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        my_linkedList list = new my_linkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.printList();

        int element = list.get(1);
        System.out.println("Element at index 1: " + element);

        list.remove(1);
        list.printList();
    }
}
