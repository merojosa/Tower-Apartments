package construction_devices;

public class AlarmFactory extends DeviceFactory
{

	@Override
	protected Device createDevice()
	{
		return new AlarmActuator();
	}

}
