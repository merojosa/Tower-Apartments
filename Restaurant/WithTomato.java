
public class WithTomato  implements SandwichInterface{
	private Sandwich sandwich;
	
	public WithTomato(Sandwich sandwich) {
		this.sandwich = sandwich; 
	}
	

	public String descripcion() {
		return sandwich.descripcion() + "with Tomato";
	}
	
	public int price() {
		return sandwich.price() + 0.5;
	}
}
