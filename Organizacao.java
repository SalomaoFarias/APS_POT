package POT_code;

public class Organizacao {
    public static void InsectionSort(int x[]) { //trocar x para matriz
        int temp, i, j = 0;
        
        for(i = 1; i < x.length; i++) { 
            j = i;
            while(j > 0 && x[j] < x[j-1]) {
                temp = x[j];
                x[j] = x[j-1];
                x[j-1] = temp;
                j = j - 1;
            }
        }
    }
    
    public static void SelectionSort(int x[]) {
        int j=0, aux, men;

        for(int i = 0; i < x.length; i++) {
            men = i;
            for(j = (i+1); j < x.length; j++) {
                if(x[j] < x[men]) {
                    men = j;
                }
            }
            if(x[i] != x[men]) {
                aux = x[i];
                x[i] = x[men];
                x[men] = aux;
            }
        }
    }

    public static void BubbleSort(int x[]) {
        int aux;

        for(int i = 0; i < x.length; i++) {
            for(int j = 0; j < x.length; j++) {
                if(j != (x.length - 1)  && x[j] > x[j+1]) {
                    aux = x[j];
                    x[j] = x[j+1];
                    x[j+1] = aux;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {2, 4, 1};

        /*int b [][] = {{2,4,1},{9,6,3}}
         * 
        public static void outputArray(int[][] array){
        //FAZ UM LOOP PELAS COLUNAS DA LINHA ATUAL
            for(int linha = 0; linha < array.length; linha++){
            //FAZ LOOP PELAS COLUNAS DA LINHA ATUAL
                for( int coluna = 0; coluna < array[linha].length; coluna++)
                    System.out.printf("%d ", array[linha][coluna]);
                    System.out.println();
                }
            }
        }
        */

        //InsectionSort(a);
        //SelectionSort(a);
        //BubbleSort(a);
        for(int k = 0; k < a.length; k++) {
            System.out.print(a[k] + ", ");
        }
        System.out.println("}");
        
    }
}
