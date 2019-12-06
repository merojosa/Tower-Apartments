package construction_devices;

import management.MediatorApartment;

public class TempFactory extends DeviceFactory<Integer>
{
	@Override
	protected Device<Integer> createDevice(MediatorApartment mediator) 
	{
		return new TempSensor(mediator);
	}
}
