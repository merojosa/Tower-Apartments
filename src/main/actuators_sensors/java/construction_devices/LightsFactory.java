package construction_devices;

public class LightsFactory extends DeviceFactory 
{

	@Override
	protected Device createDevice() 
	{
		return new LightsActuator();
	}

}
