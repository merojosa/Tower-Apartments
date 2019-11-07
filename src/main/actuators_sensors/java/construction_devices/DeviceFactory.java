package construction_devices;

import management.Mediator;

public abstract class DeviceFactory
{	
	public Device create(Mediator mediator)
	{
		return createDevice(mediator);
	}
	
	protected abstract Device createDevice(Mediator mediator);
}
