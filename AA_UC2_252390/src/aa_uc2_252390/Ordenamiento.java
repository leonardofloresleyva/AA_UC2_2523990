package aa_uc2_252390;

/**
 * Clase que contiene diferentes algoritmos de
 * ordenamiento, los cuales serán estudiados durante
 * la segunda unidad de competencia de la asignatura
 * Análisis de Algoritmos.
 * @author Leonardo Flores Leyva - 252390
 */
public class Ordenamiento {
    
    
    public static void insercion(int[] a){
        for (int i = 1; i < a.length; i++) {
            int key = a[i]; // elemento llave
            int j = i - 1; // índice j
            while (a[j] > key && j >= 0) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    }
    /**
     * Algoritmo de ordenamiento "Burbuja"
     * o BubbleSort.
     * @param a Arreglo de números enteros.
     * @return Arreglo ordenado.
     */
    public static int[] burbuja(int[] a){
        // asig: 1 + comp: n + 1 + incr: n = 2n + 2
        for (int i = 1; i < a.length; i++) {
            // (asig: 1 + comp: n + 1 + rest: n + 1 + incr: n = 3n + 3) * n = 3n^2 + 3n
            for (int j = 0; j < a.length - i; j++) {
                /*
                    Si el elemento siguiente 
                    es mayor que el elemento actual.
                */
                if(a[j]>a[j+1]){ // (comp: 1 + sum: 1 = 2) * n = 2n
                    //Intercambia ambos elementos.
                    int aux = a[j]; // (asig: 1) * n = n
                    a[j] = a[j+1]; // (asig: 1 + sum: 1 = 2) * n = 2n
                    a[j+1] = aux; // (sum: 1 + asig: 1 = 2) * n = 2n
                }
            }
        }
        return a; // return: 1
    } // Total = 2n + 2 + 3n^2 + 3n + 2n + n + 2n + 2n = 3n^2 + 12n + 2 = O(n^2)
    
     
    /**
     * Una versión optimizada del algoritmo de
     * ordenamiento Burbuja o BubbleSort.
     * @param a Arreglo de números enteros.
     * @return Arreglo ordenado.
     */
    public static int[] burbujaOptimizado(int a[]){
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < a.length - 1; i++) {
            swapped = false;
            for (j = 0; j < a.length - i - 1; j++) {
                /*
                    Si el elemento siguiente 
                    es mayor que el elemento actual.
                */
                if (a[j] > a[j + 1]) {
                    //Intercambia ambos elementos.
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }

            /*
                Si ningún elemento se intercambió,
                entonces se sale del ciclo.
            */
            if (swapped == false)
                break;
        }
        return a;
    }
    
    public static void escribirArreglo(int[] a){
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}