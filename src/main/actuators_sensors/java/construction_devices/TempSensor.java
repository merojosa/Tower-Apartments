package construction_devices;

public class TempSensor extends Device 
{
	private int temperature;
	
	@Override
	public IdDevice getId() 
	{
		return IdDevice.TEMP;
	}
	
	public int getTemperature()
	{
		return temperature;
	}
	
	public void setTemperature(int temperature)
	{
		this.temperature = temperature;
	}
}
