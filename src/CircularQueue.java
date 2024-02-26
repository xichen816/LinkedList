/**
 * Classe représentant une file d’attente circulaire
 */
public class CircularQueue {
    private int size;
    private int front, rear;
    private int space = 100;
    private final int[] queue;


    public CircularQueue(){ // donne une taille à la file
        this.queue = new int[space];
    }

    public int size() { // retourne la taille de la file
        return ((rear - front + space) % space);
    }

    public boolean isEmpty() { // regarde si la file est vide
        return (front == rear);
    }

    public void enqueue(int value){ // ajoute les éléements à la file
        if (size == space - 1) {
            throw new IllegalStateException();
        }

        else{
           queue[rear] = value;
        }
        rear = (rear + 1) % space; // calcul l'espace disponible dans la liste
        size++;
    }

    public int dequeue(){ // enlève les éléments de la file
        if (isEmpty()){
            throw new IllegalStateException("La liste est vide");
        }
        else{
            int value = queue[front];
            front = (front + 1) % space; // calcul l'espace disponible
            return value;
        }
    }

    public void front(){ // trouve le devant de la file
        this.front = -1;
    }

    public void rear(){ // trouve la prochaine case vide de la liste
        this.rear = -1;
    }

    public int space(){ // te donne la taille complète de la file
        this.space = 100;
        return space;
    }

    public void print(){ // imprime la file
        System.out.print("[");
       for (int i = 0; i < rear; i++){
           System.out.print(queue[i]);
           if(i < rear -1){
               System.out.print(", ");
           }
       }
       System.out.println("]");
    }


    /**
     *  Inverse l'ordre de la file d'attente circulaire
     */
    public void reverse(){
        int[] temp = new int[size]; // Créer une liste temporaire
        for (int i = 0; i < size; i++) {
            temp[i] = dequeue(); // Renverser l'ordre de la file
        }
        for (int i = 0; i < size; i++) {
            enqueue(temp[i]); // Enfiler dans la file originale
        }
    }

    /**
     * Vérifie si l'élément est dans la file d'attente
     * @param value la valeur à vérifier
     * @return vrai si l'élément est dans la file, faux sinon
     */
    public boolean checkInQueue(int value){
        for (int i = 0; i < size; i++){
            if (queue[i] == value){;
                return true;
            }
        }
        return false;
    }

    /**
     * Retire la première apparition de la valeur
     * @param value la valeur retirée
     */
    public void remove(int value){

        // Vérifier si la file est vide
        if (isEmpty()){
            return;
        }
        // Vérifier si la valeur se trouve au début de la file
        if (queue[front] == value){
            dequeue();
            return;
        }
        enqueue(dequeue()); // Déplacer le premier élément à la fin de la liste
        remove(value); // Continuer la recherche
    }
}
