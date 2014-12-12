package model;

import java.util.ArrayList;

public class MotBienParenthese {
	private static String parentheseOuvrante = "(";
	private static String parentheseFermante = ")";
	private static int compteurOuvrante = 0;
	private static int compteurFermante = 0;
	private static ArrayList list = new ArrayList();
	private static int compteur = 0;
	private static int altitude = 0;
	private static int nb = 0;

	public static void enumMotsBP(int n){	
		n*=2;

		if(n <= 0){ 
			System.out.println("0 mot");
			return;
		}
		else if(n == 2){ 
			addOuvrante();
			addFermante();
			System.out.println("");
			return;
		}
		else {
			list.add("");
			for(int i = 0 ; i < list.size() ; i++){
				for(int j = 0; j < list.size() ; j++){
					String a = apliquerConstructeur((String)list.get(i),(String) list.get(j));
					String b = apliquerConstructeur((String)list.get(j),(String) list.get(i));
					
					if(a.length() <= n){
						list.add(a);

					}else if (b.length() <= n){
						list.add(b);
					}
				}
			}

			delete(n);
			
		}

	}

	private static void delete(int n){
		for(int j = 0; j < list.size(); j++){
		for(int i = 0 ; i < list.size(); i++){
			if(((String) list.get(i)).length() != n ){
				list.remove(i);
			}
		}
		
		}
		for(int i = 0; i < list.size();i++){
			System.out.println(list.get(i));
		}
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
		compteur = 0;
		compteurFermante = 0;
		compteurOuvrante = 0;
	}
	private static void addFermante(){
		System.out.print(")");
		compteurFermante++;
		compteur++;
		altitude--;
	}



}
