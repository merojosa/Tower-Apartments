package construction_devices;

import actions.SmokeDetectedAction;
import management.MediatorApartment;

public class SmokeSensor extends Device<Boolean>
{	
	private boolean detection;

	
	public SmokeSensor(MediatorApartment mediator) 
	{
		super(mediator);
		detection = false;
	}

	@Override
	public void setState(Boolean state) 
	{
		detection = state;
		
		if(state == true)
		{
			mediator.notifyAction(new SmokeDetectedAction(this));
		}
	}


	@Override
	public Boolean getState() 
	{
		return detection;
	}
}
