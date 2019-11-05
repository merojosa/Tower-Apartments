package construction_devices;

public abstract class Device 
{
	public enum IdDevice 
	{
		TEMP, SMOKE, MOVEMENT, LIGHTS, AC, ALARM;
	}

	public abstract IdDevice getId();
}
