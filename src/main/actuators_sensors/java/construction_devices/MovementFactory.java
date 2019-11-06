package construction_devices;

import management.Mediator;

public class MovementFactory extends DeviceFactory
{

	@Override
	protected Device createDevice(Mediator mediator) 
	{
		return new MovementSensor(mediator);
	}

}
