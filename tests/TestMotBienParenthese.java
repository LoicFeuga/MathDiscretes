package tests;

import model.MotBienParenthese;

public class TestMotBienParenthese {

	public static void main(String[] args) {
		System.out.println("Les mots bien parenthésé de longueur 0 :");
		MotBienParenthese.enumMotsBP(0);
		MotBienParenthese.reset();
		System.out.println("Les mots bien parenthésé de longueur 1 :");
		MotBienParenthese.enumMotsBP(1);
		MotBienParenthese.reset();
		System.out.println("Les mots bien parenthésé de longueur 2 :");
		MotBienParenthese.enumMotsBP(2);
		MotBienParenthese.reset();
		System.out.println("Les mots bien parenthésé de longueur 3 :");
		MotBienParenthese.enumMotsBP(3);
		MotBienParenthese.reset();
		System.out.println("Les mots bien parenthésé de longueur 4 :");
		MotBienParenthese.enumMotsBP(4);
		MotBienParenthese.reset();
		System.out.println("Les mots bien parenthésé de longueur 5 :");
		MotBienParenthese.enumMotsBP(5);
		MotBienParenthese.reset();
		System.out.println("Les mots bien parenthésé de longueur 6 :");
		MotBienParenthese.enumMotsBP(6);
		MotBienParenthese.reset();
	}
}
