package aa_uc2_252390;

/**
 * 
 * Clase que contiene diferentes algoritmos de
 * búsqueda (los conteos están desactualizados).
 * @author Leonardo Flores Leyva - 252390
 */
public class Busqueda {
    /**
     * Búsqueda lineal de un elemento en
     * un arreglo de números enteros.
     * @param a Arreglo donde se busca el elemento
     * @param t Elemento "target" a encontrar
     * @return Posición del target en el arreglo o -1 si no se encuentra
     */
    public static int busquedaLineal(int[] a, int t){
        for (int i = 0; i < a.length; i++) { // Inicializaciones (1), comparaciones n+1, incrementos n = 2n + 2
            if(a[i] == t) //comparaciones (n)
                return i; // 1
        }
        return -1; //1
    } // Total 2n + 2 + n + 1 + 1 = 3n + 4
    
    /**
     * Búsqueda binaria iterativa.
     * @param a Arreglo donde se busca el elemento
     * @param t Elemento "target" a encontrar
     * @return Posición del target en el arreglo o -1 si no se encuentra
     */
    public static int busquedaBinIterativa(int[] a, int t){
        int izq = 0; // 1
        int der = a.length - 1; // 1+1 = 2
        while(izq <= der){ // log n
            // alternativa: int m = (izq + der) / 2; // 3 log n
            int m = izq + (der - izq)/2; // 1+1+1+1 = 4 * log n
            if(a[m] == t) // log n - 1
                return m; // 0
            else if(a[m] < t) // log n
                izq = m + 1; // 2 *  log n
            else // log n
                der = m - 1; // 2 * n

        } // 10 log n
        return - 1; // 1
    } // 10logn + 4 = O(log n)
    
    /**
     * Llama al método recursivo de
     * búsqueda binaria.
     * @param a Arreglo con el que se va a trabajar.
     * @param t Valor objetivo o target.
     * @return Posición del valor a buscar. Se devuelve -1 si no se encontró.
     */
    public static int busqBinaria(int[] a, int t){
        // Índice izquierdo.
        int izq = 0; // asig: 1
        // Índice derecho.
        int der = a.length - 1; // rest: 1 + asig: 1 = 2
        // Índice del medio.
        int medio = -1; // asig: 1
        // Regresa el resultado del método recursivo.
        return recursivo(a, t, medio, izq, der) + 1; // 11(log n) + 1
         //Total: 11(log n) + 5 = O(log n).
    }
    
    /**
     * Método recursivo de búsqueda
     * binaria.
     * @param a Arreglo.
     * @param t Target u objetivo.
     * @param m Índice del medio.
     * @param izq Índice izquierdo.
     * @param der Índice derecho.
     * @return Posición del target en el arreglo.
     */
    private static int recursivo(int[] a, int t, int m, int izq, int der){
        // Operación para obtener el índice medio.
        m = izq + (der - izq) / 2; // (rest: 1 + div: 1 + sum: 1 + asig: 1 = 4) * log n = 4log n
        // Caso base.
        
        if(izq > der)
            return - 2;
        
        if(a[m] == t){ // (comp: 1) * log n = log n (peor caso)
            // Retorna m.
            return m; // retr: 1
        }
        
        // Si la posición del arreglo en m es menor que el target.
        else if(a[m] < t) // (comp: 1) * log n = log n (peor caso)
            // Índice izquierdo es igual a m+1. Llamada recursiva.
            return recursivo(a, t, m, m +1, der); // 2log n (peor caso) | Si la condición no se cumple, no se suma al total.
        
        // Si la posición del arreglo en m es mayor que el target.
        else // log n (peor caso)
            // Índice derecho es igual a m+1. Llamada recursiva.
            return recursivo(a, t, m, izq, m-1); // 2log n (peor caso) | Si la condición no se cumple, no se suma al total.
        
    } // Total de este método: 4log n + log n + log n +2log n + log n + 2log n + 1 = 11(log n) + 1 (suma bruta).
}