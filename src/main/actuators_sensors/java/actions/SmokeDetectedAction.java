package actions;

import construction_devices.Device;
import construction_devices.SmokeSensor;

public class SmokeDetectedAction extends ActionDeviceCommand
{

	public SmokeDetectedAction(Device device) 
	{
		super(device);
	}

	@Override
	public void execute() 
	{
		((SmokeSensor) device).detectSmoke();
	}

	@Override
	protected String getImplementedKey() 
	{
		return getPartialKey() + "_" + true;
	}

}
