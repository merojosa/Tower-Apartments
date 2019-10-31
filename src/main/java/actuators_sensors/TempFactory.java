package actuators_sensors;

public class TempFactory extends DeviceFactory 
{
	@Override
	protected Device createDevice() 
	{
		return new TempSensor();
	}
}
