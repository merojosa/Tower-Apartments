package construction_devices;

import management.MediatorApartment;

public class LightsActuator extends Device
{
	private boolean state;

	
	public LightsActuator(MediatorApartment mediator)
	{
		super(mediator);
	}
	
	
	public void turnOff()
	{
		state = false;
	}
	
	
	public void turnOn()
	{
		state = true;
	}
	
	
	public boolean getState()
	{
		return state;
	}

}
