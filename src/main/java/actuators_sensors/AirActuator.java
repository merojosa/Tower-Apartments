package actuators_sensors;

public class AirActuator extends Device
{
	private boolean state;

	@Override
	public IdDevice getId() 
	{
		return IdDevice.AC;
	}
	
	public void turnOff()
	{
		state = false;
	}
	
	public void turnOn()
	{
		state = true;
	}
	
	public boolean getState()
	{
		return state;
	}
	

}
