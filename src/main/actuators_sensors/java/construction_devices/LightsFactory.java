package construction_devices;

import management.Mediator;

public class LightsFactory extends DeviceFactory 
{

	@Override
	protected Device createDevice(Mediator mediator) 
	{
		return new LightsActuator(mediator);
	}

}
