import java.io.*;
import java.util.Scanner;

public class Zombie {
    public static void main(String[] args) throws Exception {
        int n = 0;
        int m = 0;
        int[][] numbers = new int[0][0];

        File file = new File("src/sample.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            String[] dimensions = scanner.nextLine().split(" ");

            n = Integer.parseInt(dimensions[0]);
            m = Integer.parseInt(dimensions[1]);
            numbers = new int[n][m];

            for (int i = 0; i < n; i++) {
                String[] number = scanner.nextLine().split(" ");
                for (int j = 0; j < m; j++) {
                    numbers[i][j] = Integer.parseInt(number[j]);
                }
            }

            findZombie(numbers);

            System.out.println("----------------------------");

        }
        scanner.close();
    }

    public static void arrayToString(int[][] numbers){
        System.out.print("");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("[");
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j]);
                if (j < numbers[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (i < numbers.length - 1) {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println();
    }

    public static void findZombie(int[][] numbers){
        CreateQueue queueLigne = new CreateQueue();
        CreateQueue queueColonne = new CreateQueue();

        boolean looking = true;
        int iteration = 0;

        System.out.println("Itération : " + iteration);
        arrayToString(numbers);

        while(looking){
            looking = false;

            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers[i].length; j++) {

                    if(numbers[i][j] == 1){

                        if(j > 0 && numbers[i][j-1] == 2){
                            queueLigne.enqueue(i);
                            queueColonne.enqueue(j);
                            looking = true;
                        }
                        else if(j < numbers[i].length-1 && numbers[i][j+1] == 2){
                            queueLigne.enqueue(i);
                            queueColonne.enqueue(j);
                            looking = true;
                        }
                        else if(i > 0 && numbers[i-1][j] == 2){
                            queueLigne.enqueue(i);
                            queueColonne.enqueue(j);
                            looking = true;
                        }
                        else if(i < numbers.length-1 && numbers[i+1][j] == 2){
                            queueLigne.enqueue(i);
                            queueColonne.enqueue(j);
                            looking = true;
                        }
                    }
                }
            }

            while(!queueColonne.isEmpty()){
                numbers[queueLigne.dequeue()][queueColonne.dequeue()] = 2;
            }

            iteration = iteration + 1;
            System.out.println("Itération : " + iteration);
            arrayToString(numbers);
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if(numbers[i][j] == 1){
                    System.out.println("IL RESTE DES HUMAINS");
                }
            }
        }
    }
}
