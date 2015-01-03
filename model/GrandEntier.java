package model;

import java.util.ArrayList;
import java.util.Random;

import exception.GrandEntierException;
import exception.IntegerNotInBaseException;

public class GrandEntier {

	private static final int BASE = 16;
	/**
	 * taille maximal d'une écrite
	 */
	private static final int MAXBITLENGTH = 10000000;
	/**
	 * Le grand entier
	 */
	private int sum;

	/**
	 * Each integer in the list in operande, will be test to be sure than each
	 * are in correct base specified by BASE
	 * 
	 * @param ge
	 *            who contains each integer
	 * @throws IntegerNotInBaseException
	 * @throws GrandEntierException
	 */
	public GrandEntier(ArrayList<Integer> ge) throws IntegerNotInBaseException,
			GrandEntierException {

		// Si le dernier integer est un 0
		if (ge.get(ge.size() - 1) == 0) {
			throw new GrandEntierException("[ERROR] Last integer is 0");
		} else {
			sum = 0;
			for (int i = 0; i < ge.size(); i++) {
				if (ge.get(i) < BASE) {
					sum += (ge.get(i) * (int) (Math.pow(BASE, i)));
				}
				// Si l'item n'est pas dans la base
				else {
					throw new IntegerNotInBaseException(ge.get(i), BASE);
				}

			}
		}
	}

	/**
	 * 
	 * @param numBits
	 *            nombre de bits pour coder l'integer
	 * @param rnd
	 */
	public GrandEntier(int numBits, Random rnd) {
		sum = rnd.nextInt((int) (Math.pow(2, numBits)));
	}

	@Override
	public String toString() {
		return "" + sum;
	}

	/**
	 * Equals
	 */
	/*
	 * @Override public boolean equals(Object arg0) { if (arg0 instanceof
	 * GrandEntier) { GrandEntier g = (GrandEntier) arg0; if (g.length() !=
	 * length()) return false; for (int i = 0; i < length(); i++) { if
	 * (((Integer) g.get(i)).equals(get(i))) {
	 * 
	 * } else return false; } } else { return false; } return true; }
	 */

	/**
	 * Taille du grand entier en integer
	 * 
	 * @return
	 */
	/*
	 * public int length() { return integerList.size(); }
	 */
	/**
	 * -1 if inferieur 0 egal 1 if superieur
	 * 
	 * @param g
	 * @return
	 */
	/*
	 * public int compareTo(GrandEntier g) { for (int i = length() - 1; i > 0;
	 * i--) { if (get(i) > g.get(i)) return 1; else if (get(i) < g.get(i))
	 * return -1; else { } } return 0; }
	 */

	public int getSum() {
		return sum;
	}

}
