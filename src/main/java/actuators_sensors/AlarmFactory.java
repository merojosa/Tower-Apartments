package actuators_sensors;

public class AlarmFactory extends DeviceFactory
{

	@Override
	protected Device createDevice()
	{
		return new AlarmActuator();
	}

}
