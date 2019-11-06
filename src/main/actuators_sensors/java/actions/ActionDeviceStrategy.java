package actions;

import construction_devices.Device;

public abstract class ActionDeviceStrategy
{		
	protected Device device;
	
	public ActionDeviceStrategy(Device device)
	{
		this.device = device;
	}
	
	public abstract void execute();
	
	public abstract String getKey();
	
	public Device getDevice()
	{
		return device;
	}
	
}
