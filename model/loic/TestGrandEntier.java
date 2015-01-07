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
		GrandEntier gpetit= new GrandEntier(list);
		System.out.println("ok");
		System.out.println("\n---Constructeurs avec nombre de bit + random");
		GrandEntier ggrand = new GrandEntier(10, new Random());
		System.out.println("ok");
		System.out.println("\n\n--Partie méthodes");
		System.out.println("---Méthode toString"); 
		System.out.println("J'attends "+list.get(2)+"x"+gpetit.getBASE()+"^2 + "+list.get(1)+"x"+gpetit.getBASE()+"^1 + "+
				list.get(0)+"x"+gpetit.getBASE()+"^0");
		System.out.println("J'obtiens : "+gpetit);
		System.out.println("\n---Méthode equals");
		System.out.println("J'attends false, j'obtiens : " + gpetit.equals(ggrand));
		System.out.println("J'attends false, j'obtiens : " + ggrand.equals(gpetit));
		System.out.println("J'attends true, j'obtiens : " + ggrand.equals(ggrand));
		System.out.println("J'attends true, j'obtiens : " + gpetit.equals(gpetit));
		System.out.println("\n---Méthode length");
		System.out.println("J'attends 3, j'obtiens : "+gpetit.length());
		System.out.println("J'attends 10, j'obtiens : "+ggrand.length());
		System.out.println("\n---Méthode compareTo");
		System.out.println("J'attends 1, j'obtiens : "+ggrand.compareTo(gpetit));
		System.out.println("J'attends -1, j'obtiens : "+gpetit.compareTo(ggrand));
		System.out.println("J'attends 0, j'obtiens : "+ggrand.compareTo(ggrand));
		System.out.println("J'attends 0, j'obtiens : "+gpetit.compareTo(gpetit));
		System.out.println("\n---Méthode shiftLeft");
		gpetit = gpetit.shitfLeft(1);
		System.out.println("J'attends "+gpetit.get(3)+"x"+gpetit.getBASE()+"^3 + "+gpetit.get(2)+"x"+gpetit.getBASE()+"^2 + "+
				gpetit.get(1)+"x"+gpetit.getBASE()+"^1 + 0x"+gpetit.getBASE()+"^0");
		System.out.println("J'obtiens : "+gpetit);
		System.out.println("\n---Méthode add");
		ArrayList list2 = new ArrayList<>();
		list2.add(9);
		list2.add(9);


		ArrayList list3 = new ArrayList<>();
		list3.add(9);
		list3.add(9);


		GrandEntier gpetit2 = new GrandEntier(list2);
		GrandEntier gpetit3 = new GrandEntier(list3);

		GrandEntier gresult = gpetit2.add(gpetit3);
		System.out.println(gpetit2);		
		System.out.println("+");
		System.out.println(gpetit3);
		System.out.println("="+gresult);
		System.out.println("\n---Méthode multiply");
		 gresult = gpetit2.multiply(gpetit3);
		System.out.println(gpetit2);		
		System.out.println("*");
		System.out.println(gpetit3);
		System.out.println("="+gresult);

	}

	public void testNewAndDisplay(){

	}
}
