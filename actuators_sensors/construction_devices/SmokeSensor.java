package construction_devices;

public class SmokeSensor extends Device 
{
	
	private boolean detection;
	
	@Override
	public IdDevice getId()
	{
		return IdDevice.SMOKE;
	}

	public boolean getDetection() 
	{
		return detection;
	}

	public void detectSmoke()
	{
		detection = true;
	}
}
