package tests;

import java.util.ArrayList;

import exception.GrandEntierException;
import exception.IntegerNotInBaseException;
import model.GrandEntier;

public class TestGrandEntier {
	
	public static void main(String[] args) throws IntegerNotInBaseException, GrandEntierException {
		
		ArrayList<Integer> list = new ArrayList();
		
		for(int i = 0; i < 10 ; i++) list.add(i);
		
		list.add(14);
		list.add(0);
		
		GrandEntier ge = new GrandEntier(list);
		
	}

}
