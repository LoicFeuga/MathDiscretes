package model;

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
	private static int compteurOuvrante;

	/** The compteur fermante. */
	private static int compteurFermante;

	/** The list. */
	private static ArrayList list = new ArrayList();

	/** The compteur. */
	private static int compteur;

	/** The altitude. */
	private static int altitude;

	/** The nb. */
	private static int nb = 0;

	/** The fin. */
	private static int fin = 0;

	private static long tab[] = new long[10000];

	/**
	 * Enum mots bp.
	 *
	 * @author loic
	 * @param n
	 *            the n
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

				/*
				 * String a = "("+ list.get(nb)+")"+ list.get(j); String b =
				 * "("+ list.get(j)+")"+ list.get(nb);
				 */

				// Sans le contains et avec le delete doublons, temps * 10+
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
				// deleteDoublons();
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
	 * 
	 * @author loic
	 * @param n
	 *            the n
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
	 * 
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
	 * @param a
	 *            the a
	 * @param b
	 *            the b
	 * @return the string
	 */
	private static String apliquerConstructeur(String a, String b) {
		return parentheseOuvrante + a + parentheseFermante + b;
	}

	/**
	 * Adds the ouvrante.
	 * 
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
	 * 
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
	 * 
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
	 * @author Arnaud Garnier
	 * @param n
	 * @return le nombre de mots bien parenthésés de longueur 2*n
	 */
	public static int catalan(int n) {
		int result = 0;
		if (n <= 1) {
			return 1;
		}
		for (int k = 0; k < n; k++) {
			result += catalan(k) * catalan(n - k - 1);
		}
		return result;
	}

	/**
	 * Catalan v2.
	 *
	 * @author Arnaud Garnier
	 * @param n
	 * @return le nombre de mots de longueur bien parenthésés de longueur 2*n,
	 *         cette fois-ci avec un tableau de long
	 */
	public static int catalan2(int n) {
		tab[n] = 0;
		tab[0] = 1;
		for (int k = 0; k < n; k++) {
			tab[n] += tab[k] * tab[n - k - 1];
		}
		return (int) tab[n];
	}

	@SuppressWarnings("unused")
	public static void testCatalan(int n) {
		long catalani;
		long t0;
		long temps;
		for (int i = 10; i <= n; i++) {
			t0 = System.currentTimeMillis();
			catalani = catalan2(i);
			temps = System.currentTimeMillis() - t0;
			System.out.println("Temps de calcul du " + i
					+ "ème nombre de Catalan : " + temps);
		}
	}

	/**
	 * @author Arnaud Garnier
	 * @param mot
	 * @return true si le mot est bien parenthésé
	 */
	public static boolean estBienParenthese(String mot) {
		String[] tab = mot.split("");
		compteurOuvrante = 0;
		compteurFermante = 0;
		boolean resultat = false;
		for (int i = 0; i <= mot.length(); i++) {
			if (tab[i].equals(parentheseFermante)) {
				compteurFermante++;
			} else if (tab[i].equals(parentheseOuvrante)) {
				compteurOuvrante++;
			}
		}
		if (compteurOuvrante == compteurFermante) {
			resultat = true;
		}
		return resultat;
	}

	/**
	 * Ecrit un mot bien parenthésé sur plusieurs lignes avec indentation
	 * 
	 * @author Arnaud Garnier
	 * @param mot
	 */
	public static String ecrireMotBienParenthese(String mot) {
		String myResult = "";
		int compteurIndentation = 0;
		String[] tab = mot.split("");
		if (!(estBienParenthese(mot))) {
			System.out.println("Votre mot n'est pas bien parenthésé.");
		} else {
			for (int i = 0; i <= mot.length(); i++) {
				if (tab[i].equals(parentheseFermante)) {
					compteurIndentation--;
				}
				for (int j = 0; j < compteurIndentation; j++) {
					myResult += " ";
				}
				if (tab[i].equals(parentheseOuvrante)) {
					compteurIndentation++;
				}
				myResult += tab[i];
				myResult += "\n";
			}
		}
		return myResult;
	}

	/**
	 * @author Arnaud Garnier
	 * @param mot
	 * @return la profondeur de parentheses d'un mot bien parenthese
	 */
	public static int profondeur(String mot) {
		compteur = 0;
		String[] tab = mot.split("");
		int tableau[] = new int[mot.length()];
		if (!(estBienParenthese(mot))) {
			System.out.println("Votre mot n'est pas bien parenthésé.");
		} else {
			for (int i = 0; i < mot.length(); i++) {
				if (tab[i].equals(parentheseFermante)) {
					compteur--;
				}
				if (tab[i].equals(parentheseOuvrante)) {
					compteur++;
				}
				tableau[i] = compteur;
			}
			for (int j = 0; j < tableau.length; j++) {
				if (tableau[j] > altitude) {
					altitude = tableau[j];
				}
			}
		}
		return altitude;
	}
}
