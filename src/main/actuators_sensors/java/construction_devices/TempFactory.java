package construction_devices;

import management.Mediator;

public class TempFactory extends DeviceFactory 
{
	@Override
	protected Device createDevice(Mediator mediator) 
	{
		return new TempSensor(mediator);
	}
}
