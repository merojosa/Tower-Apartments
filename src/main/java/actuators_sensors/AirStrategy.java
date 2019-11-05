package actuators_sensors;

public class AirStrategy implements StrategyAction
{
	private boolean state;
	
	
	public AirStrategy(boolean state)
	{
		this.state = state;
	}
	
	
	public String generateKey() 
	{
		return getClass().getName() + "_" + state;
	}

}
