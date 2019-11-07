package construction_devices;

import management.MediatorApartment;

public class MovementFactory extends DeviceFactory
{

	@Override
	protected Device createDevice(MediatorApartment mediator) 
	{
		return new MovementSensor(mediator);
	}

}
