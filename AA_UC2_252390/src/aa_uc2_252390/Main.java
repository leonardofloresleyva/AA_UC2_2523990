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
        int[] arreglo = {23, 1, 10, 5, 2};
        // Arreglo ordenado con algoritmo de inserción.
        int[] arregloOrdenado = Ordenamiento.insercion(arreglo);
        // Escritura de arreglo ordenado.
        Ordenamiento.escribirArreglo(arregloOrdenado);
    }
}