package tests;

import java.util.Date;
import java.util.Scanner;

import model.MotBienParenthese;

public class TestMotBienParenthese {

	public static void main(String[] args) {
		System.out.print("Jusqu'à ? ");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		for(int i = 0 ; i <= a ; i++){

			Date dStartDate = new Date();

			System.out.println("Les mots bien parenthésé de longueur "+i+" :");
			MotBienParenthese.enumMotsBP(i);
			MotBienParenthese.reset();
			
			Date dEndDate = new Date();
			long lExecTime = dEndDate.getTime() - dStartDate.getTime();
			System.out.println("Temps d'exécution pour "+i+" en millisecondes: " +  lExecTime );
			
		}


	}
}
