package construction_devices;

import actions.MovementDetectedAction;
import management.MediatorApartment;

public class MovementSensor extends Device<Boolean>
{
	private boolean motion;
	
	public MovementSensor(MediatorApartment mediator) 
	{
		super(mediator);
	}

	@Override
	public void setState(Boolean state) 
	{
		motion = state;
		
		if(motion == true)
		{
			mediator.notifyAction(new MovementDetectedAction(this));
		}
		
	}

	@Override
	public Boolean getState() 
	{
		return motion;
	}
}
