package construction_devices;

public class MovementSensor extends Device
{
	private boolean motion;
	
	@Override
	public IdDevice getId()
	{
		return IdDevice.MOVEMENT;
	}
	
	
	public boolean getMotion()
	{
		return motion;
	}
	
	
	public void detectMotion()
	{
		motion = true;
	}
}
