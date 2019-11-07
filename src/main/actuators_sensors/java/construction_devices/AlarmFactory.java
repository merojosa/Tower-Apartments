package construction_devices;

import management.Mediator;

public class AlarmFactory extends DeviceFactory
{

	@Override
	protected Device createDevice(Mediator mediator)
	{
		return new AlarmActuator(mediator);
	}

}
