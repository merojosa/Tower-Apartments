package construction_devices;

import actions.MakeSoundAction;
import actions.StopSoundAction;
import management.MediatorApartment;

public class AlarmActuator extends Device
{
	private boolean sound;

	
	public AlarmActuator(MediatorApartment mediator) 
	{
		super(mediator);
	}

	
	public void makeSound()
	{
		sound = true;
		mediator.notifyAction(new MakeSoundAction(this));
	}
	
	public void stopSound()
	{
		sound = false;
		mediator.notifyAction(new StopSoundAction(this));
	}
	
	public boolean getSound()
	{
		return sound;
	}

}
