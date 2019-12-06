package construction_devices;

import management.MediatorApartment;

public class MovementFactory extends DeviceFactory<Boolean>
{

	@Override
	protected Device<Boolean> createDevice(MediatorApartment mediator) 
	{
		return new MovementSensor(mediator);
	}

}
