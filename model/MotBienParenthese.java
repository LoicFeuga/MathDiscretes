package model;

public class MotBienParenthese {
	private static String parentheseOuvrante = "(";
	private static String parentheseFermante = ")";
	private static int compteurOuvrante = 0;
	private static int compteurFermante = 0;
	private static int altitude = 0;
	private static int nb = 0;

	public static void enumMotsBP(int n){		
		n*=2;
		if(n <= 0){ 
			System.out.println("0 mot");return;
		}
		if(n == 2){ 
			System.out.println("()"); return;
		}

		if(altitude == 0){
			addOuvrante();
		}
		else if(altitude >= n/2){
			addFermante();
		}

		if(altitude > nb){
			
		}

		nb++;
		enumMotsBP(n);
	}
	
	private static void addOuvrante(){
		System.out.print("(");
		compteurOuvrante++;
		altitude++;
	}
	
	private static void addFermante(){
		System.out.println(")");
		compteurFermante++;
		altitude--;
	}



}
