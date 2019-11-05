package construction_devices;

public abstract class DeviceFactory
{	
	public Device create()
	{
		return createDevice();
	}
	
	protected abstract Device createDevice();
}
