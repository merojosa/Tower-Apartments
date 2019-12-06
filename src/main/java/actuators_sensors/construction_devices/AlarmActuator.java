package construction_devices;

import actions.MakeSoundAction;
import actions.StopSoundAction;
import management.MediatorApartment;

public class AlarmActuator extends Device<Boolean>
{
	private boolean sound;

	
	public AlarmActuator(MediatorApartment mediator) 
	{
		super(mediator);
	}

	@Override
	public void setState(Boolean state) 
	{
		sound = state;
		if(state == true)
		{
			mediator.notifyAction(new MakeSoundAction(this));
		}
		else
		{
			mediator.notifyAction(new StopSoundAction(this));
		}
	}


	@Override
	public Boolean getState() 
	{
		return sound;
	}

}
