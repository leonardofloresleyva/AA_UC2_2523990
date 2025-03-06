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
        int[] arreglo = {4, 2, 6, 3, 9};
        // Arreglo ordenado con algoritmo de burbuja.
        int[] arregloOrdenado = Ordenamiento.burbuja(arreglo);
        // Escritura de arreglo ordenado.
        Ordenamiento.escribirArreglo(arregloOrdenado);
    }
}