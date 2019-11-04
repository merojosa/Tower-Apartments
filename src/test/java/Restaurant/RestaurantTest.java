package Restaurant;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import restaurant.*;

public class RestaurantTest {
	
	//private Restaurant restaurant;
	//private Sandwich sandwich;
	
	@Before
	public void initObjects()
	{

	}
	
	@Test
	public void createSandwiches() {
		SandwichFactory italianFactory = new ItalianSandwichFactory();
		SandwichFactory mexicanFactory = new MexicanSandwichFactory();
		SandwichInterface italianSandwich = new WithCheese(italianFactory.create());
		SandwichInterface mexicanSandwich = new WithCheese(new WithTomato(mexicanFactory.create()));
		
		Assert.assertTrue(italianSandwich.description().equals("Italian Sandwich with cheese"));
		
		Assert.assertTrue(mexicanSandwich.price() == 6.25);
	}
}
