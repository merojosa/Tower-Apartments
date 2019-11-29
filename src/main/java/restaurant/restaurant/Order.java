package restaurant;

public class Order  {
	
	private SandwichInterface product;
		
	public Order(SandwichInterface sandwich) {
		this.product = sandwich; 
	}
	
	public String generateBill() {
		return product.description() + ", cost: " + product.price(); 
	}
	
	public double getPrice() {
		return product.price();
	}
}
