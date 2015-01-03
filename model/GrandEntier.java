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
	private Integer sum;

	/**
	 * Liste des chiffres de l'écriture
	 */
	private ArrayList<Integer> listInteger;

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
			listInteger = new ArrayList<Integer>();
			for (int i = 0; i < ge.size(); i++) {
				if (ge.get(i) < BASE) {
					sum += ge.get(i) * (int) (Math.pow(BASE, i));
					listInteger.add(ge.get(i));
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
	 * @param n
	 * @return this * (BASE ^ n)
	 * @throws IntegerNotInBaseException
	 * @throws GrandEntierException
	 */
	public GrandEntier shiftLeft(int n) throws IntegerNotInBaseException,
			GrandEntierException {
		GrandEntier result;
		ArrayList<Integer> theList = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			theList.add(0);
		}
		for (int i = 0; i < this.getListInteger().size(); i++) {
			theList.add(this.getListInteger().get(i));
		}
		result = new GrandEntier(theList);
		return result;
	}

	/**
	 * 
	 * @param ge
	 * @return this + ge
	 * @throws GrandEntierException
	 * @throws IntegerNotInBaseException
	 */
	public GrandEntier add(GrandEntier ge) throws IntegerNotInBaseException,
			GrandEntierException {
		GrandEntier result;
		Integer addition = 0;
		ArrayList<Integer> theList = new ArrayList<Integer>();
		for (int i = 0; i < this.getListInteger().size(); i++) {
			addition = this.getListInteger().get(i)
					+ ge.getListInteger().get(i);
			theList.add(addition);
		}
		result = new GrandEntier(theList);
		return result;
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

	public Integer getSum() {
		return sum;
	}

	public ArrayList<Integer> getListInteger() {
		return listInteger;
	}
}
