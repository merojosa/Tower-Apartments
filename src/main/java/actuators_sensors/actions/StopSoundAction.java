package actions;

import construction_devices.Device;

public class StopSoundAction extends ActionDeviceCommand<Boolean>
{

	public StopSoundAction(Device<Boolean> alarm) 
	{
		super(alarm);
	}

	@Override
	public void execute() 
	{
		device.setState(false);
	}

	@Override
	protected String getImplementedKey() 
	{
		return getPartialKey() + "_" + true;
	}
}
