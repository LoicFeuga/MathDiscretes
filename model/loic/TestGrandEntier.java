package model.loic;

import java.util.ArrayList;
import java.util.Random;

import exception.GrandEntierException;
import exception.IntegerNotInBaseException;
import model.loic.*;

public class TestGrandEntier {
	
	public static void main(String[] args) throws IntegerNotInBaseException, GrandEntierException {
		TestGrandEntier t1 = new TestGrandEntier(); 
		t1.testNewAndDisplay();
		ArrayList list = new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(2);
		GrandEntier g = new GrandEntier(10, new Random());
		//System.out.println(g);
		GrandEntier ge= new GrandEntier(list);
		System.out.println(ge);
	}

	public void testNewAndDisplay(){

	}
}
