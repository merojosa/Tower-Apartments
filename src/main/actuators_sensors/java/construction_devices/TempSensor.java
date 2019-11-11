package construction_devices;


import actions.TempAction;
import management.MediatorApartment;

public class TempSensor extends Device 
{
	private int temperature;


	public TempSensor(MediatorApartment mediator) 
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
		mediator.notifyAction(new TempAction(temperature, this));
	}
}
