
public class Order {
	
	private Sandwich product;
		
	public Order(Sandwich sandwich) {
		this.product = sandwich; 
	}
	
	public String generateBill() {
		return product.description() + " cost: " + product.price(); 
	}
	
	public int getPrice() {
		return product.price();
	}
}
