/**
 * Classe représentant une liste chaînée simple
 */
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

    /**
     * Ajoute un élément au début de la liste
     * @param value l'élément ajouté
     */
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

    /**
     * Ajoute un élément à la fin de la liste
     * @param value l'élément ajouté
     */
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

    /**
     * Retire un élément au début de la liste
     * @return l'élément retiré
     */
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

    /**
     * Retire un élément à la fin de la liste
     * @return l'élément retiré
     */
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

    /**
     * Retire tous les éléments avec une certaine valeur
     * @param value la valeur à retirer
     */
    public void removeValue(int value) {
        head = removeValueRecursive(head, value);
    }


    private Node removeValueRecursive(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            size--; // Réduire la longueur de la liste lorsqu'on trouve la valeur
            return removeValueRecursive(node.next, value); // Ignorer ce nœud et continuer à parcourir
        }

        // Si la valeur du nœud actuel ne correspond pas à la valeur spécifiée,
        // passer le nœud suivant en appel récursif
        node.next = removeValueRecursive(node.next, value);
        return node;
    }

    /**
     * Renvoie le n-ième élément en partant de la fin en O(n)
     * @param nLast la valeur de "n"
     * @return le n-ième élément en partant de la fin
     */
    public int returnNLast(int nLast){
        if (nLast <= 0 || nLast > size) {
            throw new IllegalArgumentException("Valeur invalide");
        }
        Node slow = head;
        Node fast = head;

        // Déplacer le pointeur fast vers l'avant de nLast fois
        for (int i = 0; i < nLast; i++) {
            fast = fast.next;
        }

        // Déplacer slow et fast en même temps jusqu'à ce que fast atteigne la fin de la liste
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow pointe maintenant vers le n-ième élément en partant de la fin
        return slow.value;
    }

    /**
     * Vérifie si l'élément "value" est dans la liste
     * @param value l'élément à vérifier
     * @return vrai si l'élément est dans la liste, faux sinon
     */
    public boolean checkInList(int value){
        Node first = head;
        Node last = tail;

        while (first != last.next) {
            if (first.value == value) {
                return true;
            }
            first = first.next;
        }
        return false;
    }

    /**
     * Renvoie la valeur maximale stockée dans la liste.
     * @return la valeur maximale
     */
    public int maxValue() {
         Node first = head;

        return maxValueRecursive(first, first.value);
    }

    private int maxValueRecursive(Node first, int max) {
        Node last = tail;

        if (first == null) {
            return max;
        }

        if (first != last.next) {
            if (max < first.value) {
                max = first.value;
            }
        }
        return maxValueRecursive(first.next, max);
    }

    /**
     * Trie la liste
     */
    public void insertionSort() {

        // Condition qui vérifie si la liste contient seulement un élément(head)
        if (head == null || head.next == null) {
            return;
        }

        Node sorted = null; // La liste triée est initialement vide

        Node current = head; // Initialiser le nœud actuel à trier

        // Itérer à travers la liste
        while (current != null) {
            Node nextNode = current.next;

            // Si current value est inférieure ou égale au premier nœud de la liste triée,
            // on l'insère à la tête de la liste
            if (sorted == null || current.value <= sorted.value) {
                current.next = sorted; // Update la référence du nœud trié
                sorted = current; // Update son pointeur
            } else {
                // Trouver la position de current en itérant à travers le reste de la liste
                Node temp = sorted; // Nœud de la liste triée
                while (temp.next != null && temp.next.value < current.value) {
                    temp = temp.next;
                }
                // Valeur supérieure à current trouvée.
                // Ajuster les pointeurs pour situer current entre temp et temp.next
                current.next = temp.next;
                temp.next = current;
            }

            // Après insertion d'un nœud dans liste triée, passer le prochain nœud
            current = nextNode;
        }

        // Après triage de la liste, update pointeur head
        head = sorted;
    }

    /**
     * Ajouter un élément dans une liste ordonnée
     * @param value l'élément à ajouter
     */
    public void addInOrder(int value){

    }

    /**
     * Imprime la liste chaînée simple actuelle
     * @param list une liste chaînée simple
     */
    public static void printList(LinkedList list) {
        LinkedList.Node current = list.head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
