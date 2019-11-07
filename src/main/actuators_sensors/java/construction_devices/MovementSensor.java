package construction_devices;

import management.Mediator;

public class MovementSensor extends Device
{
	public MovementSensor(Mediator mediator) 
	{
		super(mediator);
	}


	private boolean motion;
	
	
	public boolean getMotion()
	{
		return motion;
	}
	
	
	public void detectMotion()
	{
		motion = true;
	}
}
