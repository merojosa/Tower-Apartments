package construction_devices;

import management.MediatorApartment;

public class AirFactory extends DeviceFactory 
{

	@Override
	protected Device createDevice(MediatorApartment mediator)
	{
		return new AirActuator(mediator);
	}

}
