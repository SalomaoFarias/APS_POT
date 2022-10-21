/*
 * Classname    (Organizacao)
 * 
 * author       (Salomão de Farias G.)
 */

package POT_code;

import java.util.*;
import java.util.Collections;

public class Organizacao {

    public static void insertionSort(int x[][]) { 
        // i percorre o vetor, j armazena o elemento comparado e trocado.
        int temp, i, j = 0, count = 0;
        float total = 0;
        
        // Loop que percorre as linhas da matriz
        for (int l = 0; l < x.length; l++) {

            // Loop que percorre as colunas da matriz
            for (i = 1; i < x[l].length; i++) { 
                j = i;

                /* Loop que que compara um elemento e
                seu antecessor, trocando quando o antecessor for maior */
                while (j > 0 && x[l][j] < x[l][j-1]) {
                    temp = x[l][j];
                    x[l][j] = x[l][j-1];
                    x[l][j-1] = temp;
                    j = j - 1;
                    count++;
                }
            }

            // Soma o número de comparações de uma linha e reseta o contador
            total = total+count;
            count = 0;
        } 
        
        // Retorna a média de comparações 
        System.out.print("Media IS = ");
        System.out.printf("%.2f %n", (total/x.length));
    }
    
    public static void selectionSort(int x[][]) {
        int j=0, aux, men, count = 0; // men é o elemento que será trocado
        float total = 0;

        // Loop que percorre as linhas da matriz
        for (int l = 0; l < x.length; l++) {
            
            // Loop que percorre as colunas da matriz
            for (int i = 0; i < x[l].length; i++) {
                men = i;

                // Percorre o vetor em busca de um valor menor que x[men]
                for (j = (i+1); j < x[l].length; j++) {
                    if (x[l][j] < x[l][men]) {
                        men = j;
                    }
                    count++;
                }

                // Troca os elementos
                if (x[l][i] != x[l][men]) {
                    aux = x[l][i];
                    x[l][i] = x[l][men];
                    x[l][men] = aux;
                }
                count++;
            }

            // Soma o número de comparações de uma linha e reseta o contador
            total = total+count;
            count = 0;
        }

        // Retorna a média de comparações 
        System.out.print("Media SS = ");
        System.out.printf("%.2f %n", (total/x.length));   
    }

    public static void bubbleSort(int x[][]) {
        int aux, count = 0;
        float total = 0;

        // Loop que percorre as linhas da matriz
        for (int l = 0; l < x.length; l++) {

            // Loop que percorre as colunas da matriz
            for (int i = 0; i < x[l].length; i++) {

                /* Loop que compara o elemento com seu sucessor, 
                    trocando quando o sucessor for menor */
                for (int j = 0; j < x[l].length; j++) {
                    if (j != (x[l].length - 1)  && x[l][j] > x[l][j+1]) {
                        aux = x[l][j];
                        x[l][j] = x[l][j+1];
                        x[l][j+1] = aux;
                    }
                    count++;
                }
            }

            // Soma o número de comparações de uma linha e reseta o contador
            total = total+count;
            count = 0;
        }

        // Retorna a média de comparações 
        System.out.print("Media BS = ");
        System.out.printf("%.2f %n", (total/x.length));
    }

    static int merge(int x[][], int l, int m, int r, int linha) {
        int count = 0;
        
        // Descobrir os tamanhos dos dois subVetores que vão ser unidos(Merge)
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Criar os vetores temporarios */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /* Copiar os elementos para os respectivos vetores */
        for (int i = 0; i < n1; ++i)
            L[i] = x[linha][l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = x[linha][m + 1 + j];
 
        // Indexes iniciais dos vetores temporarios
        int i = 0, j = 0;
 
        // Index do vetor Unificado(Merge)
        int k = l;

        /* Merge dos vetores temporarios */
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                x[linha][k] = L[i];
                i++;
                count++;
            } else {
                x[linha][k] = R[j];
                j++;
                count++;
            }
            k++;
        }
 
        /* Copiar os elementos que sobraram do L[] */
        while (i < n1) {
            x[linha][k] = L[i];
            i++;
            k++;
        }
 
        /* Copiar os elementos que sobraram do R[] */
        while (j < n2) {
            x[linha][k] = R[j];
            j++;
            k++;
        }

        return count;
    }

    public static int mergeSort(int x[][], int l, int r, int linha) {
        int count = 0;

        if (l < r) {
            // Descobrir o meio do vetor
            int m = l + (r - l) / 2;

            // Organizar a primeira e segunda parte
            count += mergeSort(x, l, m, linha);
            count += mergeSort(x, m + 1, r, linha);

            // Merge das partes organizadas
            count += merge(x, l, m, r, linha);
        }
        return count;
    }

    public static void shellSort(int x[][]) {
        int count = 0;
        float total = 0;

        for (int l = 0; l < x.length; l++) {
            int aux, esq, dir, rest = 0, c = 0, b = 0, dist = (x[l].length/2);
            
            do{
                for (int i = 0; i < x[l].length; i++){
                    esq = i;
                    dir = i + dist; 
                    if (dir <= (x[l].length -1)) {
                        if (x[l][esq] > x[l][dir]) {
                            aux = x[l][esq];
                            x[l][esq] = x[l][dir];
                            x[l][dir] = aux;
                            c++;
                        }
                        count++;
                    } 
                }

                rest = dist % 2;
                dist = dist / 2;
                if (rest != 0) dist = dist + 1;
                if (dist == 1) b++;
                
                if (c == 0 && dist == 1 && b > 1) {
                    c = -1;
                } else c = 0;

            } while (c >= 0);
            
            total = total+count;
            count = 0;
        }
        System.out.print("Media ShS = ");
        System.out.printf("%.2f %n", (total/x.length));
    }

     // n = número de colunas, i = int de um loop
    static int heapify(int x[][], int k, int n, int i, int count) {
    
        int largest = i; // largest é a root 
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // Se a esquerda(l) for maior que a root
        if (l < n && x[k][l] > x[k][largest]) largest = l;
        count++;

        // Se a direita(r) for maior que largest
        if (r < n && x[k][r] > x[k][largest]) largest = r;
        count++;

        // Se largest não for a root
        count++;
        if (largest != i) {
            int swap = x[k][i];
            x[k][i] = x[k][largest];
            x[k][largest] = swap;

            // Aplicar heapify de forma recursiva
            count = heapify(x, k, n, largest, count);
        }
        return count;
    }

    public static void heapSort(int x[][]) {
        int count = 0;
        float total = 0;

        //k marca a linha
        for (int k = 0; k < x.length; k++) {
            int n = x[k].length;

            // Criar o heap 
            for (int i = (n / 2) - 1; i >= 0; i--) {
                count = heapify(x, k, n, i, count);
            }

            // Extrair os elementos do heap um por um 
            for (int i = n - 1; i > 0; i--) {

                // Mover o root para o final
                int temp = x[k][0];
                x[k][0] = x[k][i];
                x[k][i] = temp;

                // Chamar hapify no heap reduzido
                count = heapify(x, k, i, 0, count);
            }

            // Soma o número de comparações de uma linha e reseta o contador
            total = total+count;
            count = 0;
        }

        // Retorna a média de comparações 
        System.out.print("Media HS = ");
        System.out.printf("%.2f %n", (total/x.length));
    }

    // Função para trocar dois elementos
    static void swap(int x[][], int i, int j, int l) {
        int temp = x[l][i];
        x[l][i] = x[l][j];
        x[l][j] = temp;
    }
 
    /* Essa função pega o último elemento como pivot, coloca
       o pivot em um outro vetor na possição correta, 
       e adiciona os elementos menores que o pivot na sua esquerda,
       e maiores a direita */
    static int partition(int x[][], int low, int high, int l) {
        int pivot = x[l][high];
        // Indica a menor possoção a esquerda 
        int i = (low - 1);
 
        // Loop que percorre as colunas
        for (int j = low; j <= high - 1; j++) {

            // Se o elemento j for menor que o pivot, aumente i(menor possição)
            if (x[l][j] < pivot) {
                i++;
                swap(x, i, j, l);
            }
        }
        swap(x, i + 1, high, l);
        return (i + 1);
    }
 
    /* Função do QuickSort
     *      x[] -> Vetor
     *      low -> Index do primeiro elemento
     *      high -> Index final
     *      l  -> Linha da matriz
     *      c  -> Contador
     */
    public static int quickSort(int x[][], int low, int high, int l, int c) {
        if (low < high) {

            // pi é o index da partição
            int pi = partition(x, low, high, l);
            c += pi;

            /*  Organiza os elementos que vem antes e 
               depois de pi */
            c = quickSort(x, low, pi - 1, l, c);
            c = quickSort(x, pi + 1, high, l, c);
        }
        return c;
    }

    public static void countingSort(int x[][]) {
        int c = 0;
        float total = 0;

        // Loop que percorre as linhas da matriz 
        for(int l = 0; l < x.length; l++) {
            int n = x[l].length;

            // Vetor que vai armazenar os elementos ordenados
            int output[] = new int[n];

            // Criar um vetor que contará as aparições dos elementos
            int count[] = new int[256];

            // Definir todos os indexes como 0
            for (int i = 0; i < 256; i++) count[i] = 0;

            // Contar as aparições dos elementos 
            for (int i = 0; i < n; i++) { 
                ++count[x[l][i]];
                c++;
            }

            // Faz uma conta para definir a posição dos elementos no output[]
            for (int i = 1; i <= 255; i++) count[i] += count[i - 1];

            // Adiciona os elementos no output[] de trás pra frente
            for (int i = n - 1; i >= 0; i--) {
                output[count[x[l][i]] - 1] = x[l][i];
                --count[x[l][i]];
            }

            // Copia os elementos do output[] na matriz
            for (int i = 0; i < n;  i++) x[l][i] = output[i];

            // Soma o número de comparações de uma linha e reseta o contador
            total = total+c;
            c = 0;
        }

        // Retorna a média de comparações 
        System.out.print("Media CS = ");
        System.out.printf("%.2f %n", (total/x.length));
    }

    public static void bucketSort(int x[][]) {
        int count = 0;
        float total = 0;

        // Loop pelas linhas da matriz
        for (int l = 0; l < x.length; l++) {
            int n = x[l].length;

            if (n <= 0) return;

            // 1) Criar n buckets vazios
            @SuppressWarnings("unchecked")
            Vector<Integer>[] buckets = new Vector[n];

            for (int i = 0; i < n; i++) {
                buckets[i] = new Vector<Integer>();
            }

            // 2) Colocar os elementos do vetor em baldes diferentes
            for (int i = 0; i < n; i++) {
                int idx = x[l][i] / n;
                if(idx >= n) idx = (n - 1);
                buckets[idx].add(x[l][i]);
                count++;
            }

            // 3) Organizar cada balde individualmente
            for (int i = 0; i < n; i++) {
                Collections.sort(buckets[i]);
            }

            // 4) Concatenar todos os baldes no vetor original
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    x[l][index++] = buckets[i].get(j);
                }
            }

            // Soma o número de comparações de uma linha e reseta o contador
            total = total+count;
            count = 0;
        }

        // Retorna a média de comparações
        System.out.print("Media BuS = ");
        System.out.printf("%.2f %n", (total/x.length));
    }

    // Função que retorna o maior elemento de uma linha da matriz
    static int getMax(int x[][], int n, int l)
    {
        int mx = x[l][0];
        for (int i = 1; i < n; i++)
            if (x[l][i] > mx)
                mx = x[l][i];
        return mx;
    }        

    public static void radixSort(int x[][]) {
        int c = 0;
        float total = 0;

        // Loop que percorre as linhas da matriz
        for (int l = 0; l < x.length; l++) {
            int n = x[l].length;
            int m = getMax(x, n, l); // Descobrir o maior elemento

            /* exp é o digito do elemento. exp é 10^i e i é o 
                digito atual */
            for (int exp = 1; m / exp > 0; exp *= 10){

                // Vetor que vai armazenar os elementos ordenados
                int output[] = new int[n]; 
                int i;

                // Criar um vetor que contará as aparições dos elementos
                int count[] = new int[10];
                Arrays.fill(count, 0);

                // Contar as aparições dos elementos
                for (i = 0; i < n; i++) {
                    count[(x[l][i] / exp) % 10]++;
                    c++;
                } 
        
                // Faz uma conta para definir a posição dos elementos no output[]
                for (i = 1; i < 10; i++) count[i] += count[i - 1];
        
                // Adiciona os elementos no output[] de trás pra frente
                for (i = n - 1; i >= 0; i--) {
                    output[count[(x[l][i] / exp) % 10] - 1] = x[l][i];
                    count[(x[l][i] / exp) % 10]--;
                }

                /* Copia os elementos do output[] no vetor original */
                for (i = 0; i < n;  i++) x[l][i] = output[i];
            } 

            // Soma o número de comparações de uma linha e reseta o contador
            total = total+c;
            c = 0;
        }

        // Retorna a média de comparações
        System.out.print("Media RS = ");
        System.out.printf("%.2f %n", (total/x.length));
    }

    public static void outputArray(int x[][]){
        System.out.print("{");
        //FAZ UM LOOP PELAS LINHAS DA MATRIZ
        for (int i = 0; i < x.length; i++){
            System.out.print("{");
            //FAZ UM LOOP PELAS COLUNAS DA LINHA ATUAL
            for (int k = 0; k < x[i].length; k++){
                if (k < (x[i].length - 1)) {
                    System.out.print(x[i][k] + ", ");
                } else {
                    System.out.println(x[i][k] + "} ");
                } 
            }
            if (i < (x.length - 1)) {
                System.out.print(", ");
            } else {}
        }
        System.out.println("}");
    }
}
