package construction_devices;

import management.Mediator;

public class AlarmActuator extends Device
{
	private boolean sound;

	
	public AlarmActuator(Mediator mediator) 
	{
		super(mediator);
	}

	
	public void makeSound()
	{
		sound = true;
	}
	
	public boolean getSound()
	{
		return sound;
	}

}
