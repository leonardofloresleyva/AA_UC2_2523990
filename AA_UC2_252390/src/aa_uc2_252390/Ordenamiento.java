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
    
    public static void quickSort(int[]a, int inicio, int fin){
        
        if(inicio < fin){
        // Caso recursivo
            // Obtener pivote
            int pivote = particionar(a, inicio, fin);
            // recursión de la izquierda
            quickSort(a, inicio, pivote - 1);
            // recursión de la derecha
            quickSort(a, pivote + 1, fin);
        }
    }
    
    private static  int particionar(int[] a, int inicio, int fin){
        // seleccionar el pivote
        int pivote = a[fin]; // 1
        // seleccionamos el índice más pequeño
        int i = inicio -1; // 2
        
        // recorrer todo el arreglo buscando elementos menores al pivote
        // para intercambiarlos
        for (int j = inicio; j < fin; j++) {
            if (a[j] < pivote) {
                i++;
                int aux = a[i];
                a[i] = a[j];
                a[j] = aux;
            }
        }
        int temp = a[i];
        a[i] = a[fin];
        a[fin] = temp;
        return i;
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