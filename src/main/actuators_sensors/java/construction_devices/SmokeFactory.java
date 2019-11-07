package construction_devices;

import management.Mediator;

public class SmokeFactory extends DeviceFactory
{

	@Override
	protected Device createDevice(Mediator mediator) 
	{
		return new SmokeSensor(mediator);
	}

}
