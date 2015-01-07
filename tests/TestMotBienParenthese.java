package tests;

import java.util.Date;
import java.util.Scanner;

import model.MotBienParenthese;

/**
 * The Class TestMotBienParenthese.
 * 
 * @author Arnaud Garnier and Lo�c Feuga
 */
public class TestMotBienParenthese {

	private static String motTest0 = "()))";
	private static String motTest1 = "()(()())((()))";
	private static String motTest2 = "()((()))";

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.print("Jusqu'� ? ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();

		for (int i = 0; i <= a; i++) {

			Date dStartDate = new Date();

			System.out.println("Les mots bien parenth�s� de longueur " + 2 * i
					+ " :");
			MotBienParenthese.enumMotsBP(i);
			MotBienParenthese.reset();

			Date dEndDate = new Date();
			long lExecTime = dEndDate.getTime() - dStartDate.getTime();
			System.out.println("Temps d'ex�cution pour les mots de longueur "
					+ 2 * i + " en millisecondes: " + lExecTime);
			System.out.println("Avec la m�thode catalan, on calcule : "
					+ MotBienParenthese.catalan(i) + " mot(s) de longueur " + 2
					* i + ".");
			System.out.println("Avec la m�thode catalan2, on calcule : "
					+ MotBienParenthese.catalan2(i) + " mot(s) de longueur "
					+ 2 * i + ".");
		}
		System.out
				.println("Le mot '" + motTest0 + "' est-il bien parenth�s� ?");
		System.out.println(MotBienParenthese.estBienParenthese(motTest0));
		System.out
				.println("Le mot '"
						+ motTest1
						+ "' �crit avec une parenth�se sur chaque ligne et bien indent� : ");
		System.out.println(MotBienParenthese.ecrireMotBienParenthese(motTest1));
		System.out
				.println("La profondeur de parenth�ses du mot bien parenth�s� '"
						+ motTest2 + "' :");
		System.out.println(MotBienParenthese.profondeur(motTest2));

	}
}
