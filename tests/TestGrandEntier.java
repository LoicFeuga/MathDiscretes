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
		ArrayList<Integer> listBis = new ArrayList<Integer>();
		
		list.add(1);
		list.add(2);
		listBis.add(0);
		listBis.add(1);
		System.out.println(list);
		GrandEntier g = new GrandEntier(list);
		GrandEntier ge = new GrandEntier(listBis);
		System.out.println(g);
		System.out.println(ge);
		System.out.println(g.add(ge));
		System.out.println(g.shiftLeft(1));
		System.out.println("La longueur de ce grand entier : " + g.length());
		System.out.println("Quelques grands entiers aléatoires :");
		for (int i = 0; i < 10; i++) {
			// un grand entier compris entre 0 et 7 ( = 2^3 -1)
			GrandEntier newG = new GrandEntier(3, new Random());
			System.out.println(newG);
		}
		System.out.println("g plus grand que ge ?");
		System.out.println(g.compareTo(ge));

	}

}
