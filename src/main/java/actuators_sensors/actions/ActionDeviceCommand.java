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
	
	protected abstract String getImplementedKey();
	
	protected String getPartialKey()
	{
		return getClass().getName() + "_" + device.hashCode();
	}
	
	public String getKey()
	{
		return getPartialKey() + "_" + getImplementedKey();
	}
	
	public Device getDevice()
	{
		return device;
	}
	
}
