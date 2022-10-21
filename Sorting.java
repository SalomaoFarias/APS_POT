/*
 * Classname    (Sorting)
 * 
 * author       (Salomão de Farias G.)
 */

package POT_code;

import java.util.*;
import java.util.Collections;

public class Sorting {

    public static void insertionSort(int x[]) {
        // i percorre o vetor, j armazena o elemento comparado e trocado.
        int temp, i, j = 0; 
        
        for (i = 1; i < x.length; i++) { 
            j = i;
            
            /* Loop que que compara um elemento e
             seu antecessor, trocando quando o antecessor for maior */
            while (j > 0 && x[j] < x[j-1]) {
                temp = x[j];
                x[j] = x[j-1];
                x[j-1] = temp;
                j = j - 1;
            }
        }
    }
    
    public static void selectionSort(int x[]) {
        int j = 0, aux, men; // men é o elemento que será trocado

        // Loop que percorre o vetor.
        for (int i = 0; i < x.length; i++) {
            men = i;

            // Percorre o vetor em busca de um valor menor que x[men].
            for (j = (i+1); j < x.length; j++) {
                if(x[j] < x[men]) {
                    men = j;
                }
            }
            // Troca os elementos. 
            if (x[i] != x[men]) {
                aux = x[i];
                x[i] = x[men];
                x[men] = aux;
            }
        }
    }

    public static void bubbleSort(int x[]) {
        int aux;

        // Loop que percorre o vetor.
        for (int i = 0; i < x.length; i++) {

            /* Loop que compara o elemento com seu sucessor,
             trocando quando o sucessor for menor */
            for (int j = 0; j < x.length; j++) {
                if (j != (x.length - 1)  && x[j] > x[j+1]) {
                    aux = x[j];
                    x[j] = x[j+1];
                    x[j+1] = aux;
                }
            }
        }
    }

    public static void shellSort(int x[]) {
        int aux, esq, dir, rest = 0, dist = (x.length/2), c = 0, b = 0;

        do{
            for (int i = 0; i < x.length; i++){
                esq = i;
                dir = i + dist; 
                if (dir <= (x.length -1)) {
                    if (x[esq] > x[dir]) {
                        aux = x[esq];
                        x[esq] = x[dir];
                        x[dir] = aux;
                        c++;
                    }
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
    }

    static void merge(int x[], int l, int m, int r) {
        // Descobrir os tamanhos dos dois subVetores que vão ser unidos(Merge).
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Criar os vetores temporarios */
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        /* Copiar os elementos para os respectivos vetores */
        for (int i = 0; i < n1; ++i)
            L[i] = x[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = x[m + 1 + j];
 
        // Indexes iniciais dos vetores temporarios.
        int i = 0, j = 0;
 
        // Index do vetor Unificado(Merge).
        int k = l;

        /* Merge dos vetores temporarios */
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                x[k] = L[i];
                i++;
            } else {
                x[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copiar os elementos que sobraram do L[] */
        while (i < n1) {
            x[k] = L[i];
            i++;
            k++;
        }
 
        /* Copiar os elementos que sobraram do R[] */
        while (j < n2) {
            x[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int x[], int l, int r) {
        if (l < r) {
            // Descobrir o meio do vetor
            int m = l + (r - l) / 2;
 
            // Organizar a primeira e segunda parte
            mergeSort(x, l, m);
            mergeSort(x, m + 1, r);
 
            // Merge das partes organizadas
            merge(x, l, m, r);
        }
    }

    // Heap tree
    static void heapify(int x[], int n, int i) {
        // n = tamanho do vetor, i = int de um loop

        int largest = i; // largest é a root 
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // Se a esquerda(l) for maior que a root
        if (l < n && x[l] > x[largest]) largest = l;
        // Se a direita(r) for maior que largest
        if (r < n && x[r] > x[largest]) largest = r;

        // Se largest não for a root
        if (largest != i) {
            int swap = x[i];
            x[i] = x[largest];
            x[largest] = swap;

            // Aplicar heapify de forma recursiva
            heapify(x, n, largest);
        }
    }

    public static void heapSort(int x[]) {
        int n = x.length;

        // Criar o heap 
        for (int i = (n / 2) - 1; i >= 0; i--) heapify(x, n, i);
        
        // Extrair os elementos do heap um por um 
        for (int i = n - 1; i > 0; i--) {
           
            // Mover o root para o final
            int temp = x[0];
            x[0] = x[i];
            x[i] = temp;
            
            // Chamar hapify no heap reduzido
            heapify(x, i, 0);
        }
    }

    // Função para trocar dois elementos
    static void swap(int x[], int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
 
    /* Essa função pega o último elemento como pivot, coloca
       o pivot em um outro vetor na possição correta, 
       e adiciona os elementos menores que o pivot na sua esquerda,
       e maiores a direita */
    static int partition(int x[], int low, int high) {
        int pivot = x[high];
        // Indica a menor possoção a esquerda 
        int i = (low - 1);
        
        // Loop que percorre o vetor 
        for (int j = low; j <= high - 1; j++) {
            // Se o elemento j for menor que o pivot, aumente i(menor possição)
            if (x[j] < pivot) {
                i++;
                swap(x, i, j);
            }
        }
        swap(x, i + 1, high);
        return (i + 1);
    }
 
    /* Função do QuickSort
     *      x[] -> Vetor
     *      low -> Index do primeiro elemento
     *      high -> Index final
     */
    static void quickSort(int x[], int low, int high) {
        if (low < high) {
            
            // pi é o index da partição
            int pi = partition(x, low, high);
 
            /*  Organiza os elementos que vem antes e 
               depois de pi */
            quickSort(x, low, pi - 1);
            quickSort(x, pi + 1, high);
        }
    }

    public static void countingSort(int x[]) {
        int n = x.length;

        // Vetor que vai armazenar os elementos ordenados
        int output[] = new int[n];

        // Criar um vetor que contará as aparições dos elementos 
        int count[] = new int[256];

        // Definir todos os indexes como 0
        for (int i = 0; i < 256; i++) count[i] = 0;

        // Contar as aparições dos elementos 
        for (int i = 0; i < n; i++)  ++count[x[i]];

        // Faz uma conta para definir a posição dos elementos no output[]
        for (int i = 1; i <= 255; i++) count[i] += count[i - 1];
        
        // Adiciona os elementos no output[] de trás pra frente
        for (int i = n - 1; i >= 0; i--) {
            output[count[x[i]] - 1] = x[i];
            --count[x[i]];
        }

        // Copia os elementos do output[] no vetor original  
        for (int i = 0; i < n;  i++) x[i] = output[i];
    }

    public static void bucketSort(float x[]) {
        int n = x.length;

        if (n <= 0) return;

        // 1) Criar n buckets vazios
        @SuppressWarnings("unchecked")
        Vector<Float>[] buckets = new Vector[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new Vector<Float>();
        }

        // 2) Colocar os elementos do vetor em baldes diferentes
        for (int i = 0; i < n; i++) {
            float idx = x[i] * n;
            buckets[(int)idx].add(x[i]);
        }

        // 3) Organizar cada balde individualmente
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // 4) Concatenar todos os baldes no vetor original
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                x[index++] = buckets[i].get(j);
            }
        }
    }

    // Função que retorna o maior elemento em um vetor
    static int getMax(int x[], int n)
    {
        int mx = x[0];
        for (int i = 1; i < n; i++)
            if (x[i] > mx)
                mx = x[i];
        return mx;
    }        

    public static void radixSort(int x[]) {
        int n = x.length;
        int m = getMax(x, n); // Descobrir o maior elemento

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
            for (i = 0; i < n; i++) count[(x[i] / exp) % 10]++;
    
            // Faz uma conta para definir a posição dos elementos no output[]
            for (i = 1; i < 10; i++) count[i] += count[i - 1];
    
            // Adiciona os elementos no output[] de trás pra frente
            for (i = n - 1; i >= 0; i--) {
                output[count[(x[i] / exp) % 10] - 1] = x[i];
                count[(x[i] / exp) % 10]--;
            }

            /* Copia os elementos do output[] no vetor original */
            for (i = 0; i < n;  i++) x[i] = output[i];
        } 
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};

        mergeSort(a, 0, a.length - 1);

        System.out.print("{");
        for(int k = 0; k < a.length; k++){
            if(k < (a.length - 1)) {
                System.out.print(a[k] + ", ");
            }else {
                System.out.println(a[k] + "} ");
            } 
        }
    }
}
