package construction_devices;

import management.MediatorApartment;

public abstract class Device<StateType>
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
	
	public abstract void setState(StateType state);
	public abstract StateType getState();
}
