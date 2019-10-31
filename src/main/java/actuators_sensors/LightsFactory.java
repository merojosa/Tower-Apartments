package actuators_sensors;

public class LightsFactory extends DeviceFactory 
{

	@Override
	protected Device createDevice() 
	{
		return new LightsActuator();
	}

}
