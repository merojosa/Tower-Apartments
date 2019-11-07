package restaurant;

import java.util.*;

public class Cashier {
	private ArrayList<Order> orders; 
	
	public Cashier() {
		this.orders = new ArrayList<Order>(); 
	}
	
	public void addOrder(Order order){
		orders.add(order); 
	}
	
	public String getOrder(){
		if(!orders.isEmpty()) {
			return orders.get(0).generateBill()+ " is ready"; 				
		}
		else {
			return "No orders"; 
		}
	}
	
	//Testing Method
	public String printOrders() {
		String bill = ""; 
		for(Order o: orders) {
			bill += o.generateBill()+ " ";
		}
		
		return bill; 
	}
	
	public Memento createState() {
		return new Memento(orders);
	}
	
	public void restore(Memento memento) {
		this.orders = memento.state; 
	}
	
	public static class Memento {
		
		private final ArrayList<Order> state; 
		
		private Memento(ArrayList<Order> orders)
		{
			state = new ArrayList<Order>(); 
			for (Order o: orders) {
			     state.add(o);
			}
		}	
	}	
}
