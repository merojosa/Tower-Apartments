package construction_devices;

import management.MediatorApartment;

public class SmokeFactory extends DeviceFactory
{

	@Override
	protected Device createDevice(MediatorApartment mediator) 
	{
		return new SmokeSensor(mediator);
	}

}
