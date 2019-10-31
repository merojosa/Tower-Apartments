package actuators_sensors;

public class AlarmActuator extends Device
{
	
	private boolean sound;

	@Override
	public IdDevice getId() 
	{
		return IdDevice.ALARM;
	}
	
	public void makeSound()
	{
		sound = true;
	}
	
	public boolean getSound()
	{
		return sound;
	}

}
