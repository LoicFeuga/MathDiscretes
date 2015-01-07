package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Loïc Feuga and Arnaud Garnier
 *
 */
public class GrandEntier {

	private static final int BASE = 10;
	/**
	 * Taille maximale d'une écriture
	 */
	private static final int MAXBITLENGTH = 10000000;
	/**
	 * Liste des chiffres de l'écriture
	 */
	private ArrayList<Integer> integerList;

	/**
	 * Each integer in the list in operande, will be test to be sure than each
	 * are in correct base specified by BASE
	 * 
	 * @param list
	 *            who contains each integer
	 */
	public GrandEntier(ArrayList<Integer> list) {

		// Si le dernier integer est un 0
		integerList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) >= 0 && list.get(i) < BASE) {

			}
			// Si l'item est non dans la base
			else
				return;
		}

		this.integerList = list;
	}

	public GrandEntier(int num) {
		integerList = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			integerList.add(0);
		}
	}

	/**
	 * Constructeur d'un grand entier sur numBits avec maximum compris dans la
	 * BASE, avec un random
	 * 
	 * @param numBits
	 *            nombre de bits pour coder l'integer
	 * @param rnd
	 */
	public GrandEntier(int numBits, Random rnd) {
		integerList = new ArrayList<Integer>();

		//
		for (int j = 0; j < numBits; j++) {
			int n = (int) (BASE - 1 + 1);
			int i = rnd.nextInt() % n;
			int randomNum = 0 + i;

			if (randomNum < 0)
				randomNum *= -1;

			if (j == numBits - 1 && randomNum == 0)
				j--;
			else
				integerList.add(randomNum);
		}
	}

	@SuppressWarnings("unchecked")
	public GrandEntier(GrandEntier g) {
		integerList = (ArrayList<Integer>) g.getList().clone();
	}

	/**
	 * Méthode toString Elle affiche le grand entier en puissance de la base Qui
	 * sera pris dans la ArrayList
	 */
	@SuppressWarnings("unused")
	@Override
	public String toString() {
		String str = "";
		for (int i = integerList.size() - 1, j = 0; i >= 0; i--, j++) {
			// str+=integerList.get(i)+"x"+BASE+"^"+i+" ";
			if (i < integerList.size() - 1)
				str += " + ";
			str += "" + integerList.get(i) + "x" + BASE + "^" + i;
		}

		return str;
	}

	/**
	 * Equals Test l'équalite entre deux GrandEntier
	 */
	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof GrandEntier) {
			GrandEntier g = (GrandEntier) arg0;
			if (g.length() != length())
				return false;
			for (int i = 0; i < length(); i++) {
				if (((Integer) g.get(i)).equals(get(i))) {

				} else
					return false;
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 * Taille du grand entier en integer
	 * 
	 * @return la taille d'écriture du grand entier
	 */
	public int length() {
		return integerList.size();
	}

	/**
	 * 
	 * 
	 * @param g
	 * @return -1 si this < ge, 0 si this = ge, 1 si this > ge
	 */
	public int compareTo(GrandEntier g) {
		if (length() > g.length())
			return 1;
		else if (length() < g.length())
			return -1;
		else {
			for (int i = length() - 1; i > 0; i--) {
				if (this.get(i) > g.get(i))
					return 1;
				else if (this.get(i) < g.get(i))
					return -1;
				else {
				}
			}
			return 0;
		}
	}

	/**
	 * Méthode ShiftLeft avec décalage de n 0
	 * 
	 * @param n
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GrandEntier shitfLeft(int n) {
		ArrayList al = new ArrayList<>();

		for (int i = 0; i < n; i++)
			al.add(0);

		al.addAll(integerList);

		return new GrandEntier(al);
	}

	/**
	 * 
	 * @author Loïc Feuga
	 * 
	 * @param ge
	 * @return
	 */
	public GrandEntier add(GrandEntier ge) {
		Integer retenue = 0, resultat = 0;
		GrandEntier resul = new GrandEntier(0);

		for (int i = 0; i < length(); i++) {
			resultat = get(i) + ge.get(i) + retenue;
			if (resultat >= BASE) {
				retenue = 1;
				resultat %= BASE;
			} else {
				retenue = 0;
			}
			resul.ajout(resultat);
		}

		if (retenue == 1) {
			resul.ajout(1);
		}
		return new GrandEntier(resul);
	}

	/**
	 * @author Loïc Feuga
	 * @param ge
	 * @return le produit this * ge
	 */
	public GrandEntier multiply(GrandEntier ge) {
		Integer retenue = 0, resultat = 0;
		GrandEntier total = new GrandEntier(length() + ge.length());

		// decalage
		int decalage = 0;
		for (int i = 0; i < length(); i++) {
			GrandEntier resul = new GrandEntier(0);
			for (int j = 0; j < ge.length(); j++) {
				resultat = get(i) * ge.get(j) + retenue;
				if (resultat >= BASE) {
					retenue = resultat / BASE;
					resultat = resultat % BASE;
				} else {
					retenue = 0;
				}
				resul.ajout(resultat);
			}
			if (retenue != 0) {
				resul.ajout(retenue);
				retenue = 0;
			}
			resul = resul.shitfLeft(decalage);

			decalage++;
			total = total.add(resul);
		}

		return total;
	}

	/**
	 * Ebauche de la fonction multiplyFast
	 * 
	 * @param ge
	 * @return le produit this * ge
	 */
	public GrandEntier multiplyFast(GrandEntier ge) {
		int longueur = this.length(); // les deux mots sont supposés de même
										// longueur
		ArrayList<Integer> l = new ArrayList<Integer>();
		GrandEntier resultat = new GrandEntier(l); // le grand entier final
		if (longueur < 10) {
			return multiply(ge); // sur les "petits" GrandEntier
		}
		if (!(longueur % 2 == 0)) {
			l.add(0);// si la liste est impaire on ajoute un 0 pour qu'elle
						// devienne paire, donc divisable en 2
		}

		return resultat;
	}

	public static void compareSimpleWithFast(String[] args) throws Exception {
		int n = Integer.parseInt(args[0]);
		Random r = new Random(); // génère des nombres pseudo aléatoires
		long fixedSeed = r.nextLong();
		long t0; // heure initiale d'une serie de tests de multiplication
		long simpleTime; // heure finale d'une serie de tests de multiply
		long fastTime; // heure finale d'une serie de tests de multiplyFast
		GrandEntier a, b; // les nombres à multiplier
		System.out.println("\n\n\n");
		System.out
				.println("Comparaison experimentale de la complexité de multiply et de multiplyFast");
		System.out
				.println("-----------------------------------------------------------\n");
		System.out.println("Nombre de répétitions pour chaque taille: " + n
				+ "\n");
		System.out.println(" || temps moyen | temps moyen ");
		System.out.println("# bits || multiply | multiplyFast ");
		System.out.println("----------------------------------");
		for (int l = 1; l <= MAXBITLENGTH; l *= 2) {
			r.setSeed(fixedSeed);
			System.gc(); // nettoyage pour avoir des résultats plus
							// significatifs
			t0 = System.currentTimeMillis();
			for (int i = 1; i <= n; i++) {
				a = new GrandEntier(l, r);
				b = new GrandEntier(l, r);
				a.multiply(b);
			}
			simpleTime = System.currentTimeMillis() - t0;
			r.setSeed(fixedSeed); // pour générer les memes nombres
									// pseudoaléatoire
			System.gc(); // nettoyage pour avoir des résultats plus
							// significatifs
			t0 = System.currentTimeMillis();
			for (int i = 1; i <= n; i++) {
				a = new GrandEntier(l, r);
				b = new GrandEntier(l, r);
				a.multiplyFast(b);
			}
			fastTime = System.currentTimeMillis() - t0;
			System.out.println(l + " || " + simpleTime / n + " | " + fastTime
					/ n);
		}
	}

	public void set(int i, int n) {
		integerList.set(i, n);
	}

	public void ajout(int a) {
		integerList.add(a);
	}

	public ArrayList<Integer> getList() {
		return integerList;
	}

	public int get(int i) {
		if (i >= integerList.size())
			return (Integer) 0;
		return integerList.get(i);
	}

	public int getBASE() {
		return BASE;
	}
}
