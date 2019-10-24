
public class ItalianSandwich extends Sandwich implements SandwichInterface {
	//final static int PRICE = 6; 
	public ItalianSandwich() {
		this.bread = Sandwich.Bread.CIABATTA;
		this.mainIng = Sandwich.MainIngredient.SALAMI;
		this.price = 6; 
	}
	
	public int price() {
		return price;
	}
	
	public String descripcion() {
		return "Italian Sandwich";
	}
}
