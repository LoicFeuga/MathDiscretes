package model;

import java.util.ArrayList;
import java.util.Random;

import exception.GrandEntierException;
import exception.IntegerNotInBaseException;

public class GrandEntier {

	private static final int BASE = 16;
	/**
	 * taille maximale d'une écriture
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

	@Override
	public boolean equals(Object o) {
		if (o instanceof GrandEntier) {
			if (((GrandEntier) o).getSum() == this.getSum()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @return la taille de l'écriture du grand entier
	 */

	public int length() {
		int res = 1;
		int stock = this.getSum();
		for (int i = 0; i < MAXBITLENGTH; i++) {
			stock /= 10;
			if (stock != 0) {
				res += 1;
			}
		}
		return res;
	}


	/**
	 * 
	 * @param g
	 * @return -1 si this GrandEntier est plus petit que g, 0 si égal, 1 si this
	 *         GrandEntier est plus grand que g
	 */
	public int compareTo(GrandEntier g) {
		if (this.getSum() > g.getSum()) {
			return 1;
		} else if (this.getSum() < g.getSum()) {
			return -1;
		} else {
			return 0;
		}
	}

	public int getSum() {
		return sum;
	}

}
