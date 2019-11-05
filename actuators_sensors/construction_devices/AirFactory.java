package construction_devices;

public class AirFactory extends DeviceFactory 
{

	@Override
	protected Device createDevice()
	{
		return new AirActuator();
	}

}
