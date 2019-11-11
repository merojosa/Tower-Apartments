package construction_devices;

import management.MediatorApartment;

public class TempFactory extends DeviceFactory 
{
	@Override
	protected Device createDevice(MediatorApartment mediator) 
	{
		return new TempSensor(mediator);
	}
}
