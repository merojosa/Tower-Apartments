package construction_devices;

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
	}
	
	public boolean getSound()
	{
		return sound;
	}

}
