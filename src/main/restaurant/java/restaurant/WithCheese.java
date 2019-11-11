package restaurant;

public class WithCheese implements SandwichInterface{
	private SandwichInterface sandwichWrapper;
	
	public WithCheese(SandwichInterface sandwich) {
		this.sandwichWrapper = sandwich; 
	}
	

	public String description() {
		return sandwichWrapper.description() + " with cheese";
	}
	
	public double price() {
		return sandwichWrapper.price() + 0.75;
	}
}
