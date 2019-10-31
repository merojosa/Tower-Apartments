package actuators_sensors;

public class MovementFactory extends DeviceFactory
{

	@Override
	protected Device createDevice() 
	{
		return new MovementSensor();
	}

}
