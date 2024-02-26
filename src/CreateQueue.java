public class CreateQueue { // créer une file d'attente simple chainé

    private Node head;
    private Node tail;
    private int size;

    private static class Node { // permet de créer les noeux de la file d'attente
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void enqueue(int value){ // ajoute les éléments à la file d'attente
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public int dequeue(){ // enlève les éléments à la file d'attente
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

    public int size(){ // retourne la taille de la file d'attente
        return size;
    }

    public boolean isEmpty(){ // regarde si la file d'attente est vide
        return size == 0;
    }
}
