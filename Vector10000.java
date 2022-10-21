package POT_code;

import java.util.Random;

public class Vector10000 {
   
    public static void main(String[] args) {
        Random random = new Random();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int quanv = 0, tam = 0;

        System.out.println("Quantidade de vetores: ");
        quanv = scanner.nextInt();
        System.out.println("Tamanho dos vetores: ");
        tam = scanner.nextInt();

        scanner.close();

        //Gerar matriz
        int vector[][] = new int[quanv][tam];
        for(int i = 0; i < vector.length; i++){
            for(int j = 0; j < vector[i].length; j++){
                int number = random.nextInt(99)+1;
                vector[i][j] = number;
            }
        }

        for(int k = 0; k != 1; k++) {
        //copiar matriz e organizar
            int a[][] = new int[quanv][tam];
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[i].length; j++){
                    a[i][j] = vector[i][j];
                }
            }
            Organizacao.insertionSort(a);
        }

        for(int k = 0; k != 1; k++) {
        //copiar matriz e organizar
            int a[][] = new int[quanv][tam];
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[i].length; j++){
                    a[i][j] = vector[i][j];
                }
            }
            Organizacao.selectionSort(a);
        }

        for(int k = 0; k != 1; k++) {
        //copiar matriz e organizar
            int a[][] = new int[quanv][tam];
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[i].length; j++){
                    a[i][j] = vector[i][j];
                }
            }
            Organizacao.bubbleSort(a);
        }

        for(int k = 0; k != 1; k++) {
        //copiar matriz e organizar
            int a[][] = new int[quanv][tam];
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[i].length; j++){
                    a[i][j] = vector[i][j];
                }
            }
            Organizacao.heapSort(a);
        }

        for(int k = 0; k != 1; k++) {
        //copiar matriz e organizar
            int a[][] = new int[quanv][tam];
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[i].length; j++){
                    a[i][j] = vector[i][j];
                }
            }
            int count = 0;
            float total = 0;
            for(int l = 0; l < a.length; l++) {
                int n = a[0].length;
                count = Organizacao.quickSort(a, 0, n - 1, l, count);
                total = total+count;
                count = 0;
            }
            
            System.out.print("Media QS = ");
            System.out.printf("%.2f %n", (total/a.length));
        }

        for(int k = 0; k != 1; k++) {
        //copiar matriz e organizar
            int a[][] = new int[quanv][tam];
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[i].length; j++){
                    a[i][j] = vector[i][j];
                }
            }
            float total = 0;
            for(int l = 0; l < a.length; l++) {
                total = total + Organizacao.mergeSort(a, 0, a[0].length - 1, l);
            }
            System.out.print("Media MS = ");
            System.out.printf("%.2f %n", (total/a.length));
        }

        for(int k = 0; k != 1; k++) {
        //copiar matriz e organizar
            int a[][] = new int[quanv][tam];
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[i].length; j++){
                    a[i][j] = vector[i][j];
                }
            }
            Organizacao.countingSort(a);
        }

        for(int k = 0; k != 1; k++) {
        //copiar matriz e organizar
            int a[][] = new int[quanv][tam];
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[i].length; j++){
                    a[i][j] = vector[i][j];
                }
            }
            Organizacao.bucketSort(a);
        }

        for(int k = 0; k != 1; k++) {
        //copiar matriz e organizar
            int a[][] = new int[quanv][tam];
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a[i].length; j++){
                    a[i][j] = vector[i][j];
                }
            }
            Organizacao.radixSort(a);
        }
    }
}    
