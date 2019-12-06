package construction_devices;

import management.MediatorApartment;

public class AirFactory extends DeviceFactory<Boolean>
{

	@Override
	protected Device<Boolean> createDevice(MediatorApartment mediator)
	{
		return new AirActuator(mediator);
	}

}
