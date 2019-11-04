package actuators_sensors;

public class AirFactory extends DeviceFactory 
{

	@Override
	protected Device createDevice()
	{
		return new AirActuator();
	}

}
