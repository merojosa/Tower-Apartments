package construction_devices;

public class MovementFactory extends DeviceFactory
{

	@Override
	protected Device createDevice() 
	{
		return new MovementSensor();
	}

}
