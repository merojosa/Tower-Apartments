package construction_devices;

import actions.LightsOffAction;
import actions.LightsOnAction;
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
		mediator.notifyAction(new LightsOffAction(this));
	}
	
	
	public void turnOn()
	{
		state = true;
		mediator.notifyAction(new LightsOnAction(this));
	}
	
	
	public boolean getState()
	{
		return state;
	}

}
