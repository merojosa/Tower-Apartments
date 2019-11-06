package construction_devices;

import management.Mediator;

public abstract class Device 
{
	protected Mediator mediator;
	
	public Device(Mediator mediator)
	{
		this.mediator = mediator;
	}
	
	public Mediator getMediator()
	{
		return mediator;
	}
}
