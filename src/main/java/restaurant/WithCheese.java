package restaurant;

public class WithCheese implements SandwichInterface{
	private Sandwich sandwichWrapper;
	
	public WithCheese(Sandwich sandwich) {
		this.sandwichWrapper = sandwich; 
	}
	

	public String description() {
		return sandwichWrapper.description() + "with cheese";
	}
	
	public double price() {
		return sandwichWrapper.price() + 0.75;
	}
}
