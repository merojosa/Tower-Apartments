package construction_devices;

public class TempFactory extends DeviceFactory 
{
	@Override
	protected Device createDevice() 
	{
		return new TempSensor();
	}
}
