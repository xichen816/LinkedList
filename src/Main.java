public class Main {
    public static void main(String[] args){

        // Tester removeValue
        LinkedList List = new LinkedList();
        List.addLast(1);
        List.addLast(2);
        List.addLast(2);
        List.addLast(3);
        List.addLast(4);

        System.out.println("Liste originale:");
        LinkedList.printList(List);

        int valueToRemove = 2;
        List.removeValue(valueToRemove);

        System.out.println("List après suppression de " + valueToRemove + ":");
        LinkedList.printList(List); // renvoie 1,3,4

        // Tester returnNLast
        System.out.println("N-dernier élément: " + List.returnNLast(2)); // renvoie 3
        System.out.println("N-dernier élément: " + List.returnNLast(3)); // renvoie 1
    }
}