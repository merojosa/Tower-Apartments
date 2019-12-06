package construction_devices;

import management.MediatorApartment;

public class AlarmFactory extends DeviceFactory<Boolean>
{

	@Override
	protected Device<Boolean> createDevice(MediatorApartment mediator)
	{
		return new AlarmActuator(mediator);
	}

}
