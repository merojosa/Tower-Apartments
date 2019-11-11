package actions;

import construction_devices.Device;

public abstract class ActionDeviceCommand
{		
	protected Device device;
	
	public ActionDeviceCommand(Device device)
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
