public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int first() {
        if (isEmpty()) {
            throw new IllegalStateException("Liste vide");
        }
        return head.value;
    }

    public int last() {
        if (isEmpty()) {
            throw new IllegalStateException("Liste vide");
        }
        return tail.value;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Liste vide");
        }
        int removedValue = head.value;
        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
        return removedValue;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Liste vide");
        }
        int removedValue = tail.value;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node secondLast = head;
            while (secondLast.next != tail) {
                secondLast = secondLast.next;
            }
            secondLast.next = null;
            tail = secondLast;
        }
        size--;
        return removedValue;
    }
    public void removeValue(int value){

    }

    public int returnNLast(int nLast){

        return nLast;
    }

    public boolean checkInList(int value){

        return false;
    }

    public int maxValue(){

        return 0;
    }

    public void insertionSort(){

    }

    public void addInOrder(int value){

    }
}
