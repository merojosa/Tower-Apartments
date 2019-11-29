package construction_devices;

import actions.SmokeDetectedAction;
import management.MediatorApartment;

public class SmokeSensor extends Device 
{	
	private boolean detection;

	
	public SmokeSensor(MediatorApartment mediator) 
	{
		super(mediator);
		detection = false;
	}
	

	public boolean getDetection() 
	{
		return detection;
	}

	
	public void detectSmoke()
	{
		detection = true;
		mediator.notifyAction(new SmokeDetectedAction(this));
	}
}
