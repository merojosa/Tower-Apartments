package construction_devices;

import management.MediatorApartment;

public class LightsFactory extends DeviceFactory 
{

	@Override
	protected Device createDevice(MediatorApartment mediator) 
	{
		return new LightsActuator(mediator);
	}

}
