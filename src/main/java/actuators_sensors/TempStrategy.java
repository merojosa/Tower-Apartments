package actuators_sensors;

public class TempStrategy implements StrategyAction
{
	private int tempTrigger;
	
	
	public TempStrategy(int tempTrigger)
	{
		this.tempTrigger = tempTrigger;
	}
	
	
	public String generateKey() 
	{
		return getClass().getName() + "_" + tempTrigger;
	}

}
