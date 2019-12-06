package construction_devices;

import management.MediatorApartment;

public class LightsFactory extends DeviceFactory<Boolean>
{

	@Override
	protected Device<Boolean> createDevice(MediatorApartment mediator) 
	{
		return new LightsActuator(mediator);
	}

}
