public class CreateQueue {

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

    public void enqueue(int value){
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public int dequeue(){
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

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
