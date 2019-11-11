package restaurant;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import restaurant.Cashier.Memento;

public class RestaurantTest {
	
	private SandwichFactory italianFactory; 
	private SandwichFactory mexicanFactory; 
	private SandwichInterface italianSandwich; 
	private SandwichInterface mexicanSandwich; 
	private Cashier cashier; 
	private Restaurant restaurant; 
	
	@Before
	public void initObjects()
	{
		italianFactory = new ItalianSandwichFactory();
		mexicanFactory = new MexicanSandwichFactory();
		italianSandwich = new WithCheese(italianFactory.create());
		mexicanSandwich = new WithCheese(new WithTomato(mexicanFactory.create()));
		cashier = new Cashier();
		restaurant = new Restaurant(3); 
	}
	
	@Test
	public void createSandwiches() {
		Assert.assertTrue(italianSandwich.description().equals("Italian Sandwich with cheese"));
		Assert.assertTrue(mexicanSandwich.price() == 6.25);
		Assert.assertTrue(mexicanSandwich.description().equals("Mexican Sandwich with Tomato with cheese"));
	}
	
	@Test
	public void createOrder() {
		Order order = new Order(italianSandwich);
		cashier.addOrder(order);
		Assert.assertTrue(cashier.printOrders().equals("Italian Sandwich with cheese, cost: 6.75 "));	
		Assert.assertTrue(order.getPrice() == 6.75);
	}
	
	
	@Test
	public void memento() { 
		Order order = new Order(italianSandwich);
		cashier.addOrder(order);
		Memento previousState = cashier.createState();
		Order order1 = new Order(mexicanSandwich);
		cashier.addOrder(order1);
		cashier.restore(previousState);
		Assert.assertTrue(cashier.printOrders().equals("Italian Sandwich with cheese, cost: 6.75 "));
	}
	
	@Test
	public void isEmpty() {
		Assert.assertTrue(cashier.getOrder().equals("No orders"));
	}
	@Test
	public void createRestaurant() {
		Assert.assertTrue(restaurant.getCashier(0).getOrder().equals("No orders"));
		Assert.assertTrue(restaurant.getCashier(1).getOrder().equals("No orders"));
		Assert.assertTrue(restaurant.getCashier(2).getOrder().equals("No orders"));
		
	}

}
