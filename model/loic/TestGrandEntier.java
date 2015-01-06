package model.loic;

import java.util.ArrayList;
import java.util.Random;

import exception.GrandEntierException;
import exception.IntegerNotInBaseException;
import model.loic.*;

public class TestGrandEntier {
	
	public static void main(String[] args) throws IntegerNotInBaseException, GrandEntierException {

		System.out.println("\n-TEST de la class GrandEntier");
		System.out.println("--Partie constructeurs"); 
		System.out.println("---Constructeurs avec list");
		ArrayList list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(2);
		GrandEntier ge= new GrandEntier(list);
		System.out.println("ok");
		System.out.println("\n---Constructeurs avec nombre de bit + random");
		GrandEntier g = new GrandEntier(10, new Random());
		System.out.println("ok");
		System.out.println("\n\n--Partie méthodes");
		System.out.println("---Méthode toString"); 
		System.out.println("J'attends "+list.get(2)+"x"+ge.getBASE()+"^2 + "+list.get(1)+"x"+ge.getBASE()+"^1 + "+
				list.get(0)+"x"+ge.getBASE()+"^0");
		System.out.println("J'obtiens : "+ge);
		System.out.println("\n---Méthode equals");
		System.out.println("J'attends false, j'obtiens : " + ge.equals(g));
		System.out.println("J'attends false, j'obtiens : " + g.equals(ge));
		System.out.println("J'attends true, j'obtiens : " + g.equals(g));
		System.out.println("J'attends true, j'obtiens : " + ge.equals(ge));
		System.out.println("\n---Méthode length");
		System.out.println("J'attends 3, j'obtiens : "+ge.length());
		System.out.println("J'attends 10, j'obtiens : "+g.length());


	}

	public void testNewAndDisplay(){

	}
}
