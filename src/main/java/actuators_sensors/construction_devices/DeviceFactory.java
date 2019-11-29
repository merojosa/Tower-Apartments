package construction_devices;

import management.MediatorApartment;

public abstract class DeviceFactory
{	
	public Device create(MediatorApartment mediator)
	{
		return createDevice(mediator);
	}
	
	protected abstract Device createDevice(MediatorApartment mediator);
}
