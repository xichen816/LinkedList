public class Main {
    public static void main(String[] args){

        // Tester removeValue
        LinkedList List = new LinkedList();
        List.addLast(1);
        List.addLast(2);
        List.addLast(2);
        List.addLast(3);
        List.addLast(4);
        List.addLast(5);
        List.addLast(6);
        List.addLast(7);

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
    }
}