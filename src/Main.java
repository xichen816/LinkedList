public class Main {
    public static void main(String[] args){

        // Tester removeValue
        LinkedList List = new LinkedList();
        List.addLast(1);
        List.addLast(2);
        List.addLast(2);
        List.addLast(10);
        List.addLast(4);
        List.addLast(0);
        List.addLast(9);
        List.addLast(5);

        System.out.println("Liste originale:");
        LinkedList.printList(List);

        // Enlever 2 de la liste
        int valueToRemove = 2;
        List.removeValue(valueToRemove);

        System.out.println("Liste après suppression de " + valueToRemove + ":");
        LinkedList.printList(List); // Devrait renvoyer 1,3,4

        // Tester returnNLast
        System.out.println("2e élément en partant de la fin: " + List.returnNLast(2)); // Devrait renvoyer 6
        System.out.println("3e élément en partant de la fin: " + List.returnNLast(3)); // Devrait renvoyer 5

        System.out.println(List.checkInList(2));
        System.out.println(List.maxValue());

        List.insertionSort();
        LinkedList.printList(List);

        CircularQueue circularQueue = new CircularQueue();
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        circularQueue.enqueue(6);
        circularQueue.enqueue(7);

        System.out.print("La file circulaire avant avoir changé l'ordre : ");
        circularQueue.print();

        circularQueue.reverse();
        System.out.print("La file circulaire après avoir changé l'ordre : ");
        circularQueue.print();
    }

}