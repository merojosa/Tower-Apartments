package construction_devices;

import management.MediatorApartment;

public class AlarmFactory extends DeviceFactory
{

	@Override
	protected Device createDevice(MediatorApartment mediator)
	{
		return new AlarmActuator(mediator);
	}

}
