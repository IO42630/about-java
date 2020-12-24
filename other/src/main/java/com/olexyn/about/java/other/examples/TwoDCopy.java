package examples;

import java.util.Random;
import java.util.Arrays;

public class TwoDCopy {

    /* 
     * produire une copie complete du tableau
     * a deux dimension. Attention: Cette methode
     * doit aussi fonctionner, quand les sous-tableaux
     * ne sont pas tous de la meme longueur
     */
    public static int[][] twoDimCopy(int[][] a) {
    	int[][] c = new int[a.length][];
		for (int i=0; i<a.length;i++)	{	
			c[i] = Arrays.copyOf(a[i], a[i].length);
		}
	return c;
    }

    /*
     * Produit un tableau a deux dimensions aleatoire
     * avec les dimensions du sous-tableau egalement 
     * aleatoires.
     */
    public static int[][] myRandomArray() {
        Random random = new Random();
        int n = random.nextInt(5)+2;
        int[][] t = new int[n][];
        for (int i=0; i<t.length; i++) {
            t[i] = new int[random.nextInt(3)+2];
            for (int j=0; j<t[i].length; j++) {
                t[i][j] = random.nextInt(10);
            }
        }
        return t;
    }

    public static void main(String[] args) {
        int[][] t = myRandomArray();
        System.out.println("t = "+Arrays.deepToString(t));
        int[][] c = twoDimCopy(t);
        System.out.println("c = "+Arrays.deepToString(c)+"\n");
        // Remplir tous les entres avec -1
        for (int[] sousTableau : c) {
            Arrays.fill(sousTableau,-1);
        }
        // Vraie copie ou modification de t?
        System.out.println("t = "+Arrays.deepToString(t));
        System.out.println("c = "+Arrays.deepToString(c));
    }
}