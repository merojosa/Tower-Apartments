package construction_devices;

import management.MediatorApartment;

public class SmokeSensor extends Device 
{	
	private boolean detection;

	
	public SmokeSensor(MediatorApartment mediator) 
	{
		super(mediator);
	}
	

	public boolean getDetection() 
	{
		return detection;
	}

	
	public void detectSmoke()
	{
		detection = true;
	}
}
