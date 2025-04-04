package aa_uc2_252390;

/**
 *
 * @author Leonardo Flores Leyva - 252390
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Arreglo de ejemplo
        int[] arreglo = {20, 2, 9, 7, 12 , 15, 1, 6, 8};
        // Arreglo ordenado con algoritmo de inserción.
        int[] arregloOrdenado = Ordenamiento.quickSort(
                arreglo, 
                0, 
                arreglo.length - 1
        );
        // Escritura de arreglo ordenado.
        Ordenamiento.escribirArreglo(arregloOrdenado);
    }
}

