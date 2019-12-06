package actions;

import construction_devices.Device;

public class LightsOnAction extends ActionDeviceCommand<Boolean>
{

	public LightsOnAction(Device<Boolean> lights)
	{
		super(lights);
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
