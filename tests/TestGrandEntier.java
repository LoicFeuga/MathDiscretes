package tests;

import java.util.ArrayList;

import exception.IntegerNotInBaseException;
import model.GrandEntier;

public class TestGrandEntier {
	
	public static void main(String[] args) throws IntegerNotInBaseException {
		
		ArrayList<Integer> list = new ArrayList();
		
		for(int i = 0; i < 10 ; i++) list.add(i);
		
		list.add(15);
		
		GrandEntier ge = new GrandEntier(list);
		
	}

}
