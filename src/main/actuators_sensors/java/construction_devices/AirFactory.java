package construction_devices;

import management.Mediator;

public class AirFactory extends DeviceFactory 
{

	@Override
	protected Device createDevice(Mediator mediator)
	{
		return new AirActuator(mediator);
	}

}
