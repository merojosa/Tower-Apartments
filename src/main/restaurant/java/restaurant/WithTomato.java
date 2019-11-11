package restaurant;

public class WithTomato implements SandwichInterface{
	private SandwichInterface sandwichWrapper;
	
	public WithTomato(SandwichInterface sandwich) {
		this.sandwichWrapper = sandwich; 
	}
	

	public String description() {
		return sandwichWrapper.description() + " with Tomato";
	}
	
	public double price() {
		return sandwichWrapper.price() + 0.5;
	}
}
