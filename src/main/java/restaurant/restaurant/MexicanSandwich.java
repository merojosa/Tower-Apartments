package restaurant;

public class MexicanSandwich extends Sandwich implements SandwichInterface{
	//final static int PRICE = 5; 
	public MexicanSandwich() {
		this.bread = Sandwich.Bread.MEXICAN_BREAD;
		this.mainIng = Sandwich.MainIngredient.CARNITAS;
		this.price = 5; 
	}
	public double price() {
		return price;
	}
	
	public String description() {
		return "Mexican Sandwich";
	}
	
}
