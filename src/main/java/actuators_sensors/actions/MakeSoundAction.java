package actions;

import construction_devices.Device;

public class MakeSoundAction extends ActionDeviceCommand<Boolean>
{

	public MakeSoundAction(Device<Boolean> alarm)
	{
		super(alarm);
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
