package construction_devices;

public class SmokeFactory extends DeviceFactory
{

	@Override
	protected Device createDevice() 
	{
		return new SmokeSensor();
	}

}
