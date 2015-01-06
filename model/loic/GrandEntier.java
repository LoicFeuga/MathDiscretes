package model.loic;

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
	 *    TEST OK
	 * @param list who contains each integer
	 * @throws IntegerNotInBaseException 
	 * @throws GrandEntierException 
	 */
	public GrandEntier(ArrayList<Integer> list) throws IntegerNotInBaseException, GrandEntierException{

		//Si le dernier integer est un 0
		if(list.get(list.size()-1) == 0) throw new GrandEntierException("[ERROR] Last integer is 0 ");
		integerList = new ArrayList();
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) >= 0 && list.get(i) < BASE){ 

			}
			//Si l'item est non dans la base
			else throw new IntegerNotInBaseException(list.get(i),BASE);
		}

		this.integerList = list;
	}

	/**
	 * Constructeur  d'un grand entier sur numBits avec maximum compris dans la BASE, avec un random
	 * TEST ok
	 * @param numBits nombre de bits pour coder l'integer
	 * @param rnd 
	 */
	public GrandEntier(int numBits, Random rnd){
		Integer old_numBits = new Integer(numBits);
		integerList = new ArrayList();

		//
		for(int j = 0 ; j < numBits ;j++){
			int n = (int) (BASE - 1 + 1);
			int i = rnd.nextInt() % n;
			int randomNum =  0 + i;

			if(randomNum < 0) randomNum*=-1;

			if(j == numBits - 1 && randomNum == 0) j--;
			else integerList.add(randomNum);


		}

	}


	/**
	 * Méthode toString
	 * Elle affiche le grand entier en puissance de la base
	 * Qui sera pris dans la ArrayList
	 * TEST OK
	 */
	@Override
	public String toString() {
		String str ="";
		for(int i = integerList.size() - 1, j = 0 ; i >= 0 ;i--,j++){
			//str+=integerList.get(i)+"x"+BASE+"^"+i+" ";
			if(i <integerList.size() - 1)str+=" + ";
			str+=""+integerList.get(i)+"x"+BASE+"^"+i;
		}

		return str;
	}

	/**
	 * Equals
	 * Test l'équalite entre deux GrandEntier 
	 * TEST OK
	 */
	@Override
	public boolean equals(Object arg0) {
		if(arg0 instanceof GrandEntier) {
			GrandEntier g = (GrandEntier) arg0;
			if(g.length() != length()) return false;
			for(int i = 0; i < length(); i++){
				if(((Integer)g.get(i)).equals(get(i))){

				}else return false;
			}
		}else{
			return false;
		}
		return true;
	}
	/**
	 * Taille du grand entier en integer
	 * @return
	 */
	public int length(){
		return integerList.size();
	}


	/**
	 * -1 this inferieur
	 * 0 egal
	 * 1 this superieur
	 * @param g
	 * @return
	 */
	public int compareTo(GrandEntier g) {
		if(length() > g.length() ) return 1;
		else if(length() < g.length() ) return -1;
		else{
			for(int i = length()-1; i > 0;i--){
				if(this.get(i) > g.get(i)) return 1;
				else if(this.get(i) < g.get(i)) return -1;
				else {}
			}
			return 0;
		}
	}
	
	/**
	 * Méthode ShiftLeft
	 * Décalage de n 0 
	 * @param n
	 */
	public void shitfLeft(int n){
		ArrayList al = new ArrayList<>();
		
		for(int i = 0; i < n ; i++)	al.add(0);
		
		al.addAll(integerList);
		integerList = al;
	}
	
	public ArrayList getList(){return integerList;}

	public int get(int i){return integerList.get(i);}
	
	public int getBASE(){return BASE;}
}
