package construction_devices;

import management.Mediator;

public class SmokeSensor extends Device 
{	
	private boolean detection;

	
	public SmokeSensor(Mediator mediator) 
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
