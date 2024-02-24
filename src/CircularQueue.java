/**
 * Classe représentant une file d’attente circulaire
 */
public class CircularQueue {
    private int size;
    private int front, rear;
    private int space = 100;
    private int[] queue;
    private int[] reversedQueue;


    public CircularQueue(){
        this.queue = new int[space];
        this.reversedQueue = new int[space];
    }

    public int size() {
        return ((rear - front + space) % space);
    }

    public boolean isEmpty() {
        return (front == rear);
    }

    public void enqueue(int value){
        if (size == space - 1) {
            throw new IllegalStateException();
        }

        else{
           queue[rear] = value;
        }
        rear = (rear + 1) % space;
        size++;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new IllegalStateException("La liste est vide");
        }
        else{
            int value = queue[front];
            front = (front + 1) % space;
            return value;
        }
    }

    public void front(){
        this.front = -1;
    }

    public void rear(){
        this.rear = -1;
    }

    public int space(){
        this.space = 100;
        return space;
    }

    public void print(){
        System.out.print("[");
       for (int i = 0; i < size; i++){
           System.out.print(queue[i]);
           if(i < size -1){
               System.out.print(", ");
           }
       }
       System.out.println("]");
    }


    /**
     *  Inverse l'ordre de la file d'attente circulaire
     */
    public void reverse(){
        for(int i = rear - 1; i > front - size ; i--){
            reversedQueue[front++] = queue[i];
        }
        queue = reversedQueue;
    }

    /**
     * Vérifie si l'élément est dans la file d'attente
     * @param value
     * @return vrai si l'élément est dans la file, faux sinon
     */
    public boolean checkInQueue(int value){

        return false;
    }

    /**
     * Retire la première apparition de la valeur
     * @param value la valeur retirée
     */
    public void remove(int value){

    }
}
