import java.io.*;
import java.util.Scanner;

public class Zombie {
    public static void main(String[] args) throws Exception {
        int n = 0;
        int m = 0;
        int[][] numbers = new int[0][0];

        File file = new File("src/sample.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){ // Boucle tant que le fichier n'est pas été lu au complet
            String[] dimensions = scanner.nextLine().split(" ");

            n = Integer.parseInt(dimensions[0]); // dimension de lignes
            m = Integer.parseInt(dimensions[1]); // dimension de colognes
            numbers = new int[n][m]; // taille de la matrice

            for (int i = 0; i < n; i++) { // permet d'avoir toutes les valeurs de la matrice (tableau)
                String[] number = scanner.nextLine().split(" ");
                for (int j = 0; j < m; j++) {
                    numbers[i][j] = Integer.parseInt(number[j]); // ajoute les éléments
                }
            }

            findZombie(numbers); // appel la fonction findZombie

            System.out.println("----------------------------");

        }
        scanner.close();
    }

    public static void arrayToString(int[][] numbers){ // permet de lire et d'imprimer la matrice
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

    public static void findZombie(int[][] numbers){ // permet de transformer les humains en zombie
        CreateQueue queueLigne = new CreateQueue();
        CreateQueue queueColonne = new CreateQueue();

        boolean looking = true; // permet de savoir s'il y a encore des humains à transformer
        int iteration = 0; // compteur

        System.out.println("Itération : " + iteration);
        arrayToString(numbers);

        while(looking){ // boucle qui roule tant qu'il y a encore des humains à transformer
            looking = false; // arrete la boucle quand y'a plus d'humains

            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers[i].length; j++) {

                    if(numbers[i][j] == 1){ // trouve le 1 et recherche s'il y a un 2 aux alentours

                        if(j > 0 && numbers[i][j-1] == 2){ // recherche à gauche
                            queueLigne.enqueue(i); // ajoute la position en ligne
                            queueColonne.enqueue(j); // ajoute la position en colonne
                            looking = true;
                        }
                        else if(j < numbers[i].length-1 && numbers[i][j+1] == 2){ // recherche à droite
                            queueLigne.enqueue(i); // ajoute la position en ligne
                            queueColonne.enqueue(j); // ajoute la position en colonne
                            looking = true;
                        }
                        else if(i > 0 && numbers[i-1][j] == 2){ // recherche en haut
                            queueLigne.enqueue(i); // ajoute la position en ligne
                            queueColonne.enqueue(j); // ajoute la position en colonne
                            looking = true;
                        }
                        else if(i < numbers.length-1 && numbers[i+1][j] == 2){ // recherche en bas
                            queueLigne.enqueue(i); // ajoute la position en ligne
                            queueColonne.enqueue(j); // ajoute la position en colonne
                            looking = true;
                        }
                    }
                }
            }

            while(!queueColonne.isEmpty()){
                numbers[queueLigne.dequeue()][queueColonne.dequeue()] = 2; // change les 1 en 2
            }

            iteration = iteration + 1; // compte les itérations
            System.out.println("Itération : " + iteration);
            arrayToString(numbers); // imprime la matrice
        }

        for (int i = 0; i < numbers.length; i++) { // vérifie s'il reste des humains
            for (int j = 0; j < numbers[i].length; j++) {
                if(numbers[i][j] == 1){ // s'il y a des 1, cela veut dire qu'il y a des humains
                    System.out.println("IL RESTE DES HUMAINS");
                }
            }
        }
    }
}
