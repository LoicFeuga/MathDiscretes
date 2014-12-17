package tests;

import java.util.ArrayList;
import java.util.Random;

import exception.GrandEntierException;
import exception.IntegerNotInBaseException;
import model.GrandEntier;

public class TestGrandEntier {
	
	public static void main(String[] args) throws IntegerNotInBaseException, GrandEntierException {
		
		ArrayList<Integer> list = new ArrayList();
		
		for(int i = 0; i < 10 ; i++) list.add(i);
		
		GrandEntier ge = new GrandEntier(list);
		GrandEntier g = new GrandEntier(40,new Random());
		for(int i = 0;g.length()>=39;i++){
			g = new GrandEntier(40,new Random());
			System.out.println(g + " de taille : "+g.length());
		}

	}

}
