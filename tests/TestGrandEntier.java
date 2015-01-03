package tests;

import java.util.ArrayList;
import java.util.Random;

import exception.GrandEntierException;
import exception.IntegerNotInBaseException;
import model.GrandEntier;

public class TestGrandEntier {

	public static void main(String[] args) throws IntegerNotInBaseException,
			GrandEntierException {

		ArrayList<Integer> list = new ArrayList<Integer>();

		// exemple donné dans l'énoncé
		list.add(3);
		list.add(0);
		list.add(12);
		System.out.println(list);
		GrandEntier g = new GrandEntier(list);
		System.out.println(g);
		System.out.println("La longueur de ce grand entier : " + g.length());
		System.out.println("Quelques grands entiers aléatoires :");
		for (int i = 0; i < 10; i++) {
			// un grand entier compris entre 0 et 7 ( = 2^3 -1)
			GrandEntier newG = new GrandEntier(3, new Random());
			System.out.println(newG);
		}
		/*
		 * for(int i = 0;i < 10;i++){ g = new GrandEntier(40,new Random());
		 * System.out.println(g + " de taille : "+g.length()); } GrandEntier g2
		 * = new GrandEntier(40,new Random());
		 * System.out.println(g.compareTo(g2));
		 */

	}

}
