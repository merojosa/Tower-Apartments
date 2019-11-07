package construction_devices;

import management.Mediator;

public class LightsActuator extends Device
{
	private boolean state;

	
	public LightsActuator(Mediator mediator)
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
