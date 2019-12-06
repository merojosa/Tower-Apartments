package actions;

import construction_devices.Device;

public class AirOnAction extends ActionDeviceCommand<Boolean> 
{	
	public AirOnAction(Device<Boolean> air)
	{
		super(air);
	}

	@Override
	public void execute() 
	{
		device.setState(true);
	}

	@Override
	protected String getImplementedKey() 
	{
		return getPartialKey() + "_" + true;
	}
}
