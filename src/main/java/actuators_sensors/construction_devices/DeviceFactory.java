package construction_devices;

import management.MediatorApartment;

public abstract class DeviceFactory<StateType>
{	
	public Device<StateType> create(MediatorApartment mediator)
	{
		return createDevice(mediator);
	}
	
	protected abstract Device<StateType> createDevice(MediatorApartment mediator);
}
