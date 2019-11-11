package construction_devices;

import actions.AirOffAction;
import actions.AirOnAction;
import management.MediatorApartment;

public class AirActuator extends Device
{	
	private boolean state;

	
	public AirActuator(MediatorApartment mediator) 
	{
		super(mediator);
	}

	
	public void turnOff()
	{
		state = false;
		mediator.notifyAction(new AirOffAction(this));
	}
	
	public void turnOn()
	{
		state = true;
		mediator.notifyAction(new AirOnAction(this));
	}
	
	public boolean getState()
	{
		return state;
	}
	

}
