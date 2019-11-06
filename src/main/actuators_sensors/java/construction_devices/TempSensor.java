package construction_devices;


import management.Mediator;

public class TempSensor extends Device 
{
	private int temperature;


	public TempSensor(Mediator mediator) 
	{
		super(mediator);
	}


	public int getTemperature()
	{
		return temperature;
	}
	
	
	public void setTemperature(int temperature)
	{
		this.temperature = temperature;
		//mediator.notifyAction(new TempAction(temperature));
	}
}
