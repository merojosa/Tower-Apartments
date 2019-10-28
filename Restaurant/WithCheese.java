
public class WithCheese implements SandwichInterface{
	private Sandwich sandwich;
	
	public WithCheese(Sandwich sandwich) {
		this.sandwich = sandwich; 
	}
	

	public String description() {
		return sandwich.description() + "with cheese";
	}
	
	public int price() {
		return sandwich.price() + 0.75;
	}
}
