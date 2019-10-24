
public class WithCheese implements SandwichInterface{
	private Sandwich sandwich;
	
	public WithCheese(Sandwich sandwich) {
		this.sandwich = sandwich; 
	}
	

	public String descripcion() {
		return sandwich.descripcion() + "with cheese";
	}
	
	public int price() {
		return sandwich.price() + 0.7;
	}
}
