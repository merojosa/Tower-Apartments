package actions;

import construction_devices.Device;

public class AirOffAction extends ActionDeviceCommand<Boolean>
{

	public AirOffAction(Device<Boolean> air) 
	{
		super(air);
	}

	@Override
	public void execute() 
	{
		device.setState(false);
	}

	@Override
	protected String getImplementedKey() 
	{
		return getPartialKey() + "_" + false;
	}

}
