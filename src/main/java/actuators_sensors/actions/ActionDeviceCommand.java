package actions;

import construction_devices.Device;

public abstract class ActionDeviceCommand<StateType>
{		
	protected Device<StateType> device;
	
	public ActionDeviceCommand(Device<StateType> device)
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
	
	public Device<StateType> getDevice()
	{
		return device;
	}
	
}
