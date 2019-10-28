
public class Cashier {
	private Queue<Order> orders; 
	
	public Cashier() {
		this.orders = new Queue<>(); 
	}
	
	public void addOrder(Order order){
		orders.add(order); 
	}
	
	public Order getOrder(Order order){
		return orders.add(order); 
	}
	
	
}
