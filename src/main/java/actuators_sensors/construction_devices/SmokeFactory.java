package construction_devices;

import management.MediatorApartment;

public class SmokeFactory extends DeviceFactory<Boolean>
{

	@Override
	protected Device<Boolean> createDevice(MediatorApartment mediator) 
	{
		return new SmokeSensor(mediator);
	}

}
