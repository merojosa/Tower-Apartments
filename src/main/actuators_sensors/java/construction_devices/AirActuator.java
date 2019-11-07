package construction_devices;

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
