package construction_devices;

import management.MediatorApartment;

public abstract class Device 
{
	protected MediatorApartment mediator;
	
	public Device(MediatorApartment mediator)
	{
		this.mediator = mediator;
	}
	
	public MediatorApartment getMediator()
	{
		return mediator;
	}
}
