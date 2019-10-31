package restaurant;

public abstract class SandwichFactory {
	
	public Sandwich create() {
		Sandwich sandwich = createSandwich(); 
		return sandwich; 
	}
	
	protected abstract Sandwich createSandwich();  
}
