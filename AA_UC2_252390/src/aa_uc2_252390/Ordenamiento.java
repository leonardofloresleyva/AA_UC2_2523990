package aa_uc2_252390;

/**
 *
 * @author PC WHITE WOLF
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
    
}
