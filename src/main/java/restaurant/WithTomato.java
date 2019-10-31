package restaurant;

public class WithTomato implements SandwichInterface{
	private Sandwich sandwichWrapper;
	
	public WithTomato(Sandwich sandwich) {
		this.sandwichWrapper = sandwich; 
	}
	

	public String description() {
		return sandwichWrapper.description() + "with Tomato";
	}
	
	public double price() {
		return sandwichWrapper.price() + 0.5;
	}
}
