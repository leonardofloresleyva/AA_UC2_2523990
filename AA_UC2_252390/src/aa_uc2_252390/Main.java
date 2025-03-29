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
        int[] arreglo = {5, 8, 7, 1, 3 , 6};
        // Arreglo ordenado con algoritmo de inserción.
        int[] arregloOrdenado = Ordenamiento.seleccion(arreglo);
        // Escritura de arreglo ordenado.
        Ordenamiento.escribirArreglo(arregloOrdenado);
    }
}