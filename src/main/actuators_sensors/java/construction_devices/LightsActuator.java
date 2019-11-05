package construction_devices;

public class LightsActuator extends Device
{
	private boolean state;
	
	
	@Override
	public IdDevice getId() 
	{
		return IdDevice.LIGHTS;
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
