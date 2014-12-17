package model;

import java.util.ArrayList;
import java.util.Random;

import exception.GrandEntierException;
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
	 * @throws GrandEntierException 
	 */
	public GrandEntier(ArrayList<Integer> list) throws IntegerNotInBaseException, GrandEntierException{
		
		//Si le dernier integer est un 0
		if(list.get(list.size()-1) == 0) throw new GrandEntierException("[ERROR] Last integer is 0 ");
		integerList = new ArrayList();
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) >= 0 && list.get(i) < BASE){ }
			//Si l'item est non dans la base
			else throw new IntegerNotInBaseException(list.get(i),BASE);
		}
		
		this.integerList = list;
	}
	
	/**
	 * 
	 * @param numBits nombre de bits pour coder l'integer
	 * @param rnd 
	 */
	public GrandEntier(int numBits, Random rnd){
		Integer old_numBits = new Integer(numBits);
		integerList = new ArrayList();
		//Décomposition en grand Entier du randomNum

	
		while(numBits != 0){
			int n = (int) (BASE - 0 + 1);
			int i = rnd.nextInt() % n;
			int randomNum =  0 + i;
			if(randomNum < 0) randomNum*=-1;
			if(numBits != old_numBits || randomNum != 0) {
				integerList.add(randomNum);
				
			}
			else numBits++;
			numBits--;
		}
			
	}
	
	
	
	@Override
	public String toString() {
		String str ="";
		for(int i = 0; i < integerList.size();i++){
			//str+=integerList.get(i)+"x"+BASE+"^"+i+" ";
			str+=integerList.get(i);
		}
		return str;
	}
	
	public int length(){
		return integerList.size();
	}
	
}
