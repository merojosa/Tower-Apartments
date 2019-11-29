package restaurant;

public class MexicanSandwichFactory extends SandwichFactory{
	
	protected Sandwich createSandwich() {
		return new MexicanSandwich(); 
	}
}
