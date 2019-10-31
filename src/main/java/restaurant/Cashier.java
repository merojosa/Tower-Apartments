package restaurant;

import java.util.*;

public class Cashier {
	private Queue<Order> orders; 
	
	public Cashier() {
		this.orders = new LinkedList<Order>(); 
	}
	
	public void addOrder(Order order){
		orders.add(order); 
	}
	
	public void getOrder(Order order){
		//return orders.add(order); 
	}
	
	public Memento createState() {
		return new Memento(orders);
	}
	
	public void restore(Memento memento) {
		this.orders = memento.state; 
	}
	
	public static class Memento {
		
		private final Queue<Order> state; 
		
		private Memento(Queue<Order> state)
		{
			//deep copy
			this.state = new LinkedList<Order>();
			for(Order item: state) {
				this.state.add(item); 
			}
			
		}
		

	}
	
	
}
