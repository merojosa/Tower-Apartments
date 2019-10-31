package actuators_sensors;

public class ACFactory extends DeviceFactory 
{

	@Override
	protected Device createDevice()
	{
		return new ACActuator();
	}

}
