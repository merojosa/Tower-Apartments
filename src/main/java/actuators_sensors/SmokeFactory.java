package actuators_sensors;

public class SmokeFactory extends DeviceFactory
{

	@Override
	protected Device createDevice() 
	{
		return new SmokeSensor();
	}

}
