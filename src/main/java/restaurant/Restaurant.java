package restaurant;

import java.util.*;

public class Restaurant {
	public ArrayList<Cashier> cashiers; 
	public int numberOfCashiers;
	
	public Restaurant(int numCashiers) {
		cashiers = new ArrayList<Cashier>();
		numberOfCashiers = numCashiers;
		for (int i = 0; i < numCashiers; i++) {
			cashiers.add(new Cashier());
		}
	}
}
