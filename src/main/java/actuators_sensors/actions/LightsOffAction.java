package actions;

import construction_devices.Device;

public class LightsOffAction extends ActionDeviceCommand<Boolean>
{

	public LightsOffAction(Device<Boolean> lights)
	{
		super(lights);
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
