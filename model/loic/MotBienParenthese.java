package model.loic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 * The Class MotBienParenthese.
 * 
 * @author loic, arnaud
 */
public class MotBienParenthese {
	
	/** The parenthese ouvrante. */
	private static String parentheseOuvrante = "(";
	
	/** The parenthese fermante. */
	private static String parentheseFermante = ")";
	
	/** The compteur ouvrante. */
	private static int compteurOuvrante = 0;
	
	/** The compteur fermante. */
	private static int compteurFermante = 0;
	
	/** The list. */
	private static ArrayList list = new ArrayList();
	
	/** The compteur. */
	private static int compteur = 0;
	
	/** The altitude. */
	private static int altitude = 0;
	
	/** The nb. */
	private static int nb = 0;
	
	/** The fin. */
	private static int fin = 0;

	/**
	 * Enum mots bp.
	 *
	 * @author loic
	 * @param n the n
	 */
	public static void enumMotsBP(int n) {
		n *= 2;

		// Si 0 mot
		if (n <= 0) {
			System.out.println("0 mot");
			return;
		}
		// Si 1 mot
		else if (n == 2) {
			addOuvrante();
			addFermante();
			System.out.println("");
			return;
		}
		// Tous les autres
		else {
			// Test pour ajouter qu'au début le mot vide
			if (nb == 0)
				list.add("");

			
			for (int j = 0; j < list.size(); j++) {
				String a = apliquerConstructeur((String) list.get(nb),
						(String) list.get(j));
				String b = apliquerConstructeur((String) list.get(j),
						(String) list.get(nb));
				
				/*String a = "("+ list.get(nb)+")"+ list.get(j);
				String b = "("+ list.get(j)+")"+ list.get(nb);*/

				//Sans le contains et avec le delete doublons, temps * 10+
				if (a.length() <= n && !list.contains(a) && a != "")
					list.add(a);
				if (b.length() <= n && !list.contains(b) && b != "")
					list.add(b);
			}

			// Si on a pas fini, on repart
			if (nb < list.size() && ++nb < list.size() - 1)
				enumMotsBP(n / 2);

			// Pour que la récursivité n'affiche pas n fois les () on condanme
			// avec une constante au premier passage
			if (fin == 0) {
				// On codanme
				fin++;
				// Suppression des mots avec la mauvaise longueur et des
				// doublons
				delete(n);
				//deleteDoublons();
				int i = 0;
				// Affichage des mots BP
				for (; i < list.size(); i++)
					System.out.println(list.get(i));

				System.out.println("Soit " + i + " nombres");
			}
		}
	}

	/**
	 * Delete.
	 * @author loic
	 * @param n the n
	 */
	private static void delete(int n) {
		for (int i = 0; i < list.size(); i++)
			if (((String) list.get(i)).length() != n) {
				list.remove(i);
				i--;
			}

	}

	/**
	 * Delete doublons.
	 * @author loic
	 */
	private static void deleteDoublons() {
		Set set = new HashSet();
		set.addAll(list);
		ArrayList dis = new ArrayList(set);
		list = null;
		list = dis;
	}

	/**
	 * Apliquer constructeur.
	 * 
	 * @author loic
	 *
	 * @param a the a
	 * @param b the b
	 * @return the string
	 */
	private static String apliquerConstructeur(String a, String b) {
		return parentheseOuvrante + a + parentheseFermante + b;
	}

	/**
	 * Adds the ouvrante.
	 * @author loic
	 */
	private static void addOuvrante() {
		System.out.print("(");
		compteurOuvrante++;
		compteur++;
		altitude++;
	}

	/**
	 * Reset.
	 * @author loic
	 */
	public static void reset() {
		nb = 0;
		list = null;
		altitude = 0;
		list = new ArrayList<>();
		compteur = 0;
		compteurFermante = 0;
		compteurOuvrante = 0;
		fin = 0;
	}

	/**
	 * Adds the fermante.
	 * @author loic
	 */
	private static void addFermante() {
		System.out.print(")");
		compteurFermante++;
		compteur++;
		altitude--;
	}

	/**
	 * Catalan.
	 *
	 * @author arnaud
	 * @param n the n
	 * @return the int
	 */
	public static int catalan(int n) {
		if (n <= 1) {
			return 1;
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			res += catalan(i) * catalan(n - i - 1);
		}
		return res;
	}

}
