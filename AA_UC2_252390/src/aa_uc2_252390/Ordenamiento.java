package aa_uc2_252390;

/**
 * Clase que contiene diferentes algoritmos de
 * ordenamiento, los cuales serán estudiados durante
 * la segunda unidad de competencia de la asignatura
 * Análisis de Algoritmos.
 * @author Leonardo Flores Leyva - 252390
 */
public class Ordenamiento {
    
    /**
     * Algoritmo de ordenamiento por
     * inserción (Insertion Sort).
     * @param a Arreglo de enteros.
     * @return Arreglo ordenado.
     */
    public static int[] insercion(int[] a){
        int i, j;
        int key;
        // asig:1 + comp:n+1 + iter:n = 2n + 2
        for (i = 1; i < a.length; i++) { 
            // (asig:1)*n = n
            j = i;
            // (asig:1)*n = n
            key = a[i];
            // (comp:n+1 + comp:n+1 + comp:n+1 + rest:n+1 = 4n + 4)*n = 4n^2 +4n
            while(j > 0 && key < a[j-1]){
                // ((asig:1 + rest:1 = 2)*n)*n = 2n^2
                a[j] = a[j-1];
                // ((asig:1 + rest:1 = 2)*n)*n = 2n^2
                j--;
            }
            // (asig:1)*n = n
            a[j] = key;
        }
        return a; // retr:1
        // Total = 2n + 2 + n + n + 4n^2 + 4n + 2n^2 + 2n^2 + n + 1 = 
        // 8n^2 + 9n + 3 = O(n^2)
    } 
    
    /*
        // Algoritmo de inserción original del maestro.
        for (int i = 1; i < a.length; i++) {
            int key = a[i]; // elemento llave
            int j = i - 1; // índice j
            while (a[j] > key && j >= 0) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
        }
    */
    
    /**
     * Algoritmo de ordenamiento por selección
     * (Selection Sort).
     * @param a Arreglo de números enteros.
     * @return Arreglo ordenado
     */
    public static int[] seleccion(int[] a){
        // asig: 1
        int n = a.length;
        // asig: 1 + comp: n+1 + rest: n+1 + incrm: n = 3n + 3
        for (int i = 0; i < n-1; i++) {
            // asig: (1)*n = n
            int minIndex = i;
            // (asig: 1 + suma: 1 + comp: n+1 + incrm: n = 2n + 3)*n = 2n^2 + 3n
            for (int j = i + 1; j < n; j++) {
                // ((comp: 1)*n*n) = n^2
                if (a[j] < a[minIndex]) {
                    // ((asig: 1)*n)*n) = n^2
                    minIndex = j;
                }
            }
            int aux = a[minIndex]; // (asig: 1)*n = n
            a[minIndex] = a[i]; // (asig: 1)*n = n
            a[i] = aux; // (asig: 1)*n = n
        }
        return a; // retr: 1
    } // Total: 1 + 3n + 3 + n + 2n^2 + 3n + n^2 + n^2 + n + n + n + 1 = 4n^2 + 10n + 5 = O(n^2)
    
    /**
     * Algoritmo de ordenamiento QuickSort
     * (estrategia divide y vencerás).
     * @param a Arreglo a ordenar
     * @param inicio Límite inferior
     * @param fin Límite superior
     * @return Arreglo ordenado
     */
    public static int[] quickSort(int[]a, int inicio, int fin){
        // comp: 1
        if(inicio < fin){
            // (7n + 9) + asig: 1 = 7n + 10
            int pivote = particionar(a, inicio, fin);
            // (7n + 11 + rest: 1)/2 = (7n + 12)/2 = 7n/2 + 6
            quickSort(a, inicio, pivote - 1);
            // (7n + 11 + suma: 1)/2 = (7n + 12)/2 = 7n/2 + 6
            quickSort(a, pivote + 1, fin);
        }
        return a; // retr: 1
    } // Total: log2(7n + 13) = O(nlog2(n))
    
    /**
     * Selecciona el pivote y particiona el arreglo a partir
     * de este, ordenando los elementos menores al pivote 
     * a su izquierda, y los elementos mayores a su derecha.
     * @param a Arreglo a particionar.
     * @param inicio Índice de inicio
     * @param fin Índice final
     * @return Índice del pivote
     */
    private static  int particionar(int[] a, int inicio, int fin){
        int pivote = a[fin]; // asig: 1
        int i = inicio - 1; // asig: 1 + rest: 1 = 2
        // asig: 1 + comp: n + 1 + incr: 1 = 2n + 2
        for (int j = inicio; j < fin; j++) {
            // (comp: 1)*n = n
            if (a[j] < pivote) {
                i++; // (incr: 1)*n = n
                int aux = a[i]; // (asig: 1)*n = n
                a[i] = a[j]; // (asig: 1)*n = n
                a[j] = aux; // (asig: 1)*n = n
            }
        }
        int temp = a[i + 1]; // asig: 1
        a[i + 1] = a[fin]; // asig: 1
        a[fin] = temp; // asig: 1
        return i + 1; // retr: 1
    } // Total: 1 + 2 + 2n + 2 + n + n + n + n + n + 1 + 1 + 1 + 1 = 7n + 9
    
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
                if(a[j]>a[j+1]){ // ((comp: 1 + sum: 1 = 2)*n)*n = 2n^2
                    //Intercambia ambos elementos.
                    int aux = a[j]; // ((asig: 1)*n)*n) = n^2
                    a[j] = a[j+1]; // ((asig: 1 + sum: 1 = 2)*n)*n) = 2n^2
                    a[j+1] = aux; // ((sum: 1 + asig: 1 = 2)*n)*n = 2n^2
                }
            }
        }
        return a; // return: 1
    } // Total = 2n + 2 + 3n^2 + 3n + 2n^2 + n^2 + 2n^2 + 2n^2 + 1 = 10n^2 + 3n + 3 = O(n^2)
    
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
    
    /**
     * Método simple que imprime los elementos de un
     * arreglo
     * @param a Arreglo de números enteros
     */
    public static void escribirArreglo(int[] a){
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}