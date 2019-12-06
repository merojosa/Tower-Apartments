package actions;

import construction_devices.Device;

public class SmokeDetectedAction extends ActionDeviceCommand<Boolean>
{

	public SmokeDetectedAction(Device<Boolean> device) 
	{
		super(device);
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
