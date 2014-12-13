package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MotBienParenthese {
	private static String parentheseOuvrante = "(";
	private static String parentheseFermante = ")";
	private static int compteurOuvrante = 0;
	private static int compteurFermante = 0;
	private static ArrayList list = new ArrayList();
	private static int compteur = 0;
	private static int altitude = 0;
	private static int nb = 0;
	private static int fin = 0;

	public static void enumMotsBP(int n){	
		n*=2;

		//Si 0 mot
		if(n <= 0){ 
			System.out.println("0 mot");
			return;
		}
		//Si 1 mot
		else if(n == 2){ 
			addOuvrante();
			addFermante();
			System.out.println("");
			return;
		}
		//Tous les autres
		else {
			//Test pour ajouter qu'au début le mot vide
			if(nb == 0) list.add("");
			
			for(int j = 0; j < list.size() ; j++){
				String a = apliquerConstructeur((String)list.get(nb),(String) list.get(j));
				String b = apliquerConstructeur((String)list.get(j),(String) list.get(nb));

				if(a.length() <= n && !list.contains(a) && a != "")	list.add(a);
				if (b.length() <= n && !list.contains(b) && b != "") list.add(b);
			}
			
			//Si on a pas fini, on repart
			if(nb < list.size() ){
				nb++;
				if(nb < list.size() - 1) enumMotsBP(n/2);		
			}
			
			//Pour que la récursivité n'affiche pas n fois les () on condanme avec une constante au premier passage
			if(fin == 0){
				fin++;
				//Suppression des mots avec la mauvaise longueur
				delete(n);
				//Suppression des mots en double
				deleteDoublons();
				int i = 0;
				//Affichage des mots BP
				for( ; i < list.size();i++)	System.out.println(list.get(i));
				
				System.out.println("Soit "+i+" nombres");
			}
			
		}

	}

	private static void delete(int n){

		for(int i = 0 ; i < list.size(); i++){
			if(((String) list.get(i)).length() != n ){
				list.remove(i);
				i--;
			}
		}

	}

	private static void deleteDoublons(){

		Set set = new HashSet() ;
		set.addAll(list) ;
		ArrayList dis = new ArrayList(set) ;
		list = null;
		list = dis;

	}

	private static String apliquerConstructeur(String a, String b){
		return parentheseOuvrante + a + parentheseFermante +b;		
	}

	private static void addOuvrante(){
		System.out.print("(");
		compteurOuvrante++;
		compteur++;
		altitude++;
	}

	public static void reset(){
		nb = 0;
		list = null;
		altitude = 0;
		list = new ArrayList<>();
		compteur = 0;
		compteurFermante = 0;
		compteurOuvrante = 0;
		fin = 0;
	}
	private static void addFermante(){
		System.out.print(")");
		compteurFermante++;
		compteur++;
		altitude--;
	}



}
