package model;

import java.util.ArrayList;

import exception.IntegerNotInBaseException;

public class GrandEntier {
	
	
	private static final int BASE = 10;
	/**
	 * taille maximal d'une écrite
	 */
	private static final int MAXBITLENGTH = 10000000;
	/**
	 * Liste des chiffres de l'écriture 
	 */
	private ArrayList<Integer> integerList;
	
	/**
	 * Each integer in the list in operande, will be test
	 *   to be sure than each are in correct base specified by BASE
	 *    
	 * @param list who contains each integer
	 * @throws IntegerNotInBaseException 
	 */
	public GrandEntier(ArrayList<Integer> list) throws IntegerNotInBaseException{
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) >= 0 && list.get(i) < BASE){ }
			else throw new IntegerNotInBaseException(list.get(i),BASE);
		}
		
		this.integerList = list;
	}
	
	
	
	
	
	
	
}
