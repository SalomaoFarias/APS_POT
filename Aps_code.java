package POT_code;
import java.util.Random;

public class Aps_code {
    public static void main(String[] args) {
        Random random = new Random();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int quanv = 0;
        int tam = 0;
        int c = 0;

        do {
            System.out.println("Quantidade de vetores: ");
            quanv = scanner.nextInt();
            System.out.println("Tamanho dos vetores: ");
            tam = scanner.nextInt();
            for(int i = 0; i < quanv; i++) {
                //int vector[] = new int[tam];
                for(int j = 0; j < tam /*vector.length*/; j++){
                    int number = random.nextInt(99)+1;
                    //vector[j] = number;
                    System.out.print(number/*vector[j]*/ + ", ");
                }
            System.out.println("}");
            }
        System.out.println("Deseja continuar? 0 para sim e 1 para não.");
        c = scanner.nextInt();
        }while (c == 0);
    scanner.close();
    }
}
